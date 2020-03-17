package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprContinue
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprContinue(private val el: TrExprContinue) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
