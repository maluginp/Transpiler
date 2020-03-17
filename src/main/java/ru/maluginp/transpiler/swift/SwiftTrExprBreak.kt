package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprBreak
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprBreak(private val el: TrExprBreak) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
