package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprBreak
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprBreak(private val el: TrExprBreak) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
