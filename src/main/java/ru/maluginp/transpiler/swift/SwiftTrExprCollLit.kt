package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprCollLit
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprCollLit(private val el: TrExprCollLit) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
