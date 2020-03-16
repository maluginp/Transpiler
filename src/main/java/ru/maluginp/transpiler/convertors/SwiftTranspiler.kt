package ru.maluginp.transpiler.convertors

class SwiftTranspiler : Transpiler {
    override fun format(element: TrElement): String {
        return "Element $element\n"
    }
}