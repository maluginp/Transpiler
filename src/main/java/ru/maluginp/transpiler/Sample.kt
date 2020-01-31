package ru.maluginp.transpiler

interface ICartItem {

    val amount: String

    fun test(a: Int): Int

    fun getPrice(): Double
}

class Calculator: ICartItem {
    override val amount: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun test(a: Int): Int {
        return getTester(a).toInt()
    }

    override fun getPrice(): Double {
        TODO("not implemented" + "asdasd") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getTester(a: Int): Int {
        return 1
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