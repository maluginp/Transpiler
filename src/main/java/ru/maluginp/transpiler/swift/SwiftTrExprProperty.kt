package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprProperty
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprProperty(private val el: TrExprProperty) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
