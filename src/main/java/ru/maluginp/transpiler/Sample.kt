package ru.maluginp.transpiler

interface ICartItemModifier {
    fun getPrice(): Double
}

interface ICartItem {
    fun getPrice(): Double
    fun getModifiers(): List<ICartItemModifier>
}

class CartCalculator {
    fun getCartItemPricePerQuantity(cartItem: ICartItem): Double {
        var price: Double = 0.0

        price = cartItem.getPrice()

        price += cartItem.getModifiers().map {
            it.getPrice()
        }.sum()

        return price
    }
}