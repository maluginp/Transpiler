package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprName
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprName(private val el: TrExprName) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
