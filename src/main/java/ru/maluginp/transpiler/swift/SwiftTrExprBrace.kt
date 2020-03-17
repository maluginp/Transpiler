package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprBrace
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprBrace(private val el: TrExprBrace) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
