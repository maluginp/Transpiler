package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprContinue
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprContinue(private val el: TrExprContinue) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
