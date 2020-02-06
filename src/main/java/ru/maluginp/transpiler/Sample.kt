package ru.maluginp.transpiler


interface ITax {
    fun getValue(): Double
}

interface ICartItemModifier {
    fun getPrice(): Double
}

interface IDiscount {
    fun isPercent(): Boolean
    fun getValue(): Double
}

interface ICartItem {
    fun getPrice(): Double
    fun getModifiers(): List<ICartItemModifier>
    fun getQuantity(): Float
    fun getDiscount(): IDiscount?
    fun isTaxEnabled(tax: ITax): Boolean
}

interface ICart {
    fun getCartItems(): List<ICartItem>
    fun getDiscount(): IDiscount?

    fun isDoubleDiscount(): Boolean
}

interface IOrderCalculator {
    fun getCartItemPrice(cartItem: ICartItem): Double
    fun getCartItemDiscount(cartItem: ICartItem): Double

    fun getItemsSubtotal(cart: ICart): Double
    fun getCartDiscount(cart: ICart): Double
    fun getCartDiscountForEachCartItem(cartItem: ICartItem, cart: ICart): Double

    fun getSubtotal(cart: ICart): Double
}

interface IOrderTaxCalculator {
    fun getTax(cart: ICart): Double
    fun getItemTax(cartItem: ICartItem, cart: ICart): Double
    fun isVAT(): Boolean
}


class OrderCalculator : IOrderCalculator {
    override fun getCartItemPrice(cartItem: ICartItem): Double {
        return getCartItemPricePerQuantity(cartItem) * cartItem.getQuantity()
    }

    override fun getCartItemDiscount(cartItem: ICartItem): Double {
        if (cartItem.getDiscount() != null) {
            val discount: IDiscount = cartItem.getDiscount()!!

            return if (discount.isPercent()) {
                getCartItemPricePerQuantity(cartItem) * discount.getValue() * cartItem.getQuantity()
            } else {
                discount.getValue() * cartItem.getQuantity()
            }
        }
        return 0.0
    }

    override fun getItemsSubtotal(cart: ICart): Double {
        var amount: Double = 0.0

        for (cartItem: ICartItem in cart.getCartItems()) {
            amount += getCartItemPrice(cartItem)
        }

        return amount
    }

    override fun getCartDiscount(cart: ICart): Double {
        if (cart.getCartItems().isEmpty()) {
            return 0.0
        }

        if (cart.getDiscount() == null) {
            return 0.0
        }

        val discount: IDiscount = cart.getDiscount()!!

        if (discount.isPercent()) {
            var amount: Double = 0.0
            if (cart.isDoubleDiscount()) {
                amount = (getItemsSubtotal(cart) - getItemsDiscount(cart)) * discount.getValue()
            } else {
                for (cartItem: ICartItem in cart.getCartItems()) {
                    if (cartItem.getDiscount() == null) {
                        amount += (getCartItemPrice(cartItem) * discount.getValue())
                    }
                }
            }

            return amount
        } else {
            return discount.getValue()
        }
    }

    override fun getCartDiscountForEachCartItem(cartItem: ICartItem, cart: ICart): Double {
        if (cart.getCartItems().isEmpty()) {
            return 0.0
        }

        if (cart.getDiscount() == null) {
            return 0.0
        }

        val discount: IDiscount = cart.getDiscount()!!

        return if (discount.isPercent()) {
            var amount: Double = 0.0
            if (cart.isDoubleDiscount()) {
                amount = (getCartItemPrice(cartItem) - getCartItemDiscount(cartItem)) * discount.getValue()
            } else if (cartItem.getDiscount() == null) {
                amount = getCartItemPrice(cartItem) * discount.getValue()
            }
            amount
        } else {
            val subtotalWithoutCartDiscount: Double = getItemsSubtotal(cart) - getItemsDiscount(cart)
            val discountProportion: Double = discount.getValue() / subtotalWithoutCartDiscount
            discountProportion * (getCartItemPrice(cartItem) - getCartItemDiscount(cartItem))
        }

    }

    override fun getSubtotal(cart: ICart): Double {
        return getItemsSubtotal(cart) - getItemsDiscount(cart) - getCartDiscount(cart)
    }

    private fun getItemsDiscount(cart: ICart): Double {
        var amount: Double = 0.0
        for (cartItem: ICartItem in cart.getCartItems()) {
            amount += getCartItemDiscount(cartItem)
        }
        return amount
    }

    private fun getCartItemPricePerQuantity(cartItem: ICartItem): Double {
        var amount: Double = cartItem.getPrice()

        if (cartItem.getModifiers().size > 0) {
            for (modifier: ICartItemModifier in cartItem.getModifiers()) {
                amount += modifier.getPrice()
            }
        }

        return amount
    }

}

class ExternalTaxCalculator(val orderCalculator: IOrderCalculator, val taxes: List<ITax>) : IOrderTaxCalculator {
    override fun getTax(cart: ICart): Double {
        var taxAmount: Double = 0.0

        for (cartItem: ICartItem in cart.getCartItems()) {
            taxAmount += getItemTax(cartItem, cart)
        }

        return taxAmount
    }

    override fun getItemTax(cartItem: ICartItem, cart: ICart): Double {
        var taxAmount: Double = 0.0
        val subtotal: Double =
            orderCalculator.getCartItemPrice(cartItem) - orderCalculator.getCartItemDiscount(cartItem)

        for (tax in taxes) {
            if (cartItem.isTaxEnabled(tax)) {
                taxAmount += (subtotal * tax.getValue())
            }
        }

        return taxAmount
    }

    override fun isVAT(): Boolean {
        return false
    }
}

class VATTaxCalculator(val orderCalculator: IOrderCalculator, val taxes: List<ITax>) : IOrderTaxCalculator {
    override fun getTax(cart: ICart): Double {
        var taxAmount: Double = 0.0

        for (cartItem: ICartItem in cart.getCartItems()) {
            taxAmount += getItemTax(cartItem, cart)
        }

        return taxAmount
    }

    override fun getItemTax(cartItem: ICartItem, cart: ICart): Double {
        var taxAmount: Double = 0.0
        val itemSubtotal: Double = getItemSubtotal(cartItem, cart)

        for (tax in taxes) {
            if (cartItem.isTaxEnabled(tax)) {
                val taxProportion: Double = 1 + tax.getValue()
                taxAmount += itemSubtotal - itemSubtotal / taxProportion
            }
        }

        return taxAmount
    }

    private fun getItemSubtotal(cartItem: ICartItem, cart: ICart): Double {
        var subtotal: Double = orderCalculator.getCartItemPrice(cartItem)
        subtotal -= orderCalculator.getCartItemDiscount(cartItem)
        subtotal -= orderCalculator.getCartDiscountForEachCartItem(cartItem, cart)

        subtotal /= cartItem.getQuantity()

        return subtotal
    }

    override fun isVAT(): Boolean {
        return true
    }


}