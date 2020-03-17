package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprName
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprName(private val el: TrExprName) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
