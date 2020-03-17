package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprSuper
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprSuper(private val el: TrExprSuper) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
