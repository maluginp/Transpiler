package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprStringTmpl
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprStringTmpl(private val el: TrExprStringTmpl) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
