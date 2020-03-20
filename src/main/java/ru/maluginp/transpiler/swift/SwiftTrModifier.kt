package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrModifier

class SwiftTrModifier(private val el: TrModifier) : TrImplementation {
    override fun output(): String {
        return el.expr
    }
}
