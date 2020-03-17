package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprLabeled
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprLabeled(private val el: TrExprLabeled) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
