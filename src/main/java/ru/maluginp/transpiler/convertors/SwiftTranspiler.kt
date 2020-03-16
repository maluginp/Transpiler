package ru.maluginp.transpiler.convertors

class SwiftTranspiler : Transpiler {
    override fun format(el: TrElement): String {
        return when(el) {
            is TrInterface -> "protocol ${el.name}"
            else -> "$el"
        }+"\n"
    }
}