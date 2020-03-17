package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprCollLit
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprCollLit(private val el: TrExprCollLit) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
