package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprBrace
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprBrace(private val el: TrExprBrace) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
