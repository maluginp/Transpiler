package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprWhenEntryCondition
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprWhenEntryCondition(private val el: TrExprWhenEntryCondition) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
