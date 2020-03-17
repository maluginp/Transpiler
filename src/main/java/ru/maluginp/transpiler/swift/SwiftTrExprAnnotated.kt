package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprAnnotated
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprAnnotated(private val el: TrExprAnnotated) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
