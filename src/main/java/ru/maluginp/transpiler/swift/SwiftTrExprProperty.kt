package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprProperty
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprProperty(private val el: TrExprProperty) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
