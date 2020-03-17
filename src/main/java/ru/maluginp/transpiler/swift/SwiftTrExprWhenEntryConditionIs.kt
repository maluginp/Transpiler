package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprWhenEntryConditionIs
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprWhenEntryConditionIs(private val el: TrExprWhenEntryConditionIs) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
