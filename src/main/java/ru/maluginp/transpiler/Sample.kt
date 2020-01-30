package ru.maluginp.transpiler

interface ICartItem {

    val amount: String

    fun test(a: Int): Int

    fun getPrice(): Double
}

class Calculator {
    fun getPrice(item: ICartItem): Double {
        return 0.0;
    }
}

//class CartItem: ICartItem {
//    var items: Array<String> = emptyArray()
//
//    override val amount: String
//        get() = "1"
//
//    override fun test(a: Int): Int {
//        if (items.size > 0) {
//            return 1
//        }
//
//        return 0
//    }
//}