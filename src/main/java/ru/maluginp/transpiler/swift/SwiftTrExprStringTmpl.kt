package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprStringTmpl
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprStringTmpl(private val el: TrExprStringTmpl) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
