package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprLabeled
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprLabeled(private val el: TrExprLabeled) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
