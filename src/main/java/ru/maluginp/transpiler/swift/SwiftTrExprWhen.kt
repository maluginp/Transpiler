package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprWhen
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprWhen(private val el: TrExprWhen) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
