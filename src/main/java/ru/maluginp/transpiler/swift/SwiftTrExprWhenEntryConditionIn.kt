package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprWhenEntryConditionIn
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprWhenEntryConditionIn(private val el: TrExprWhenEntryConditionIn) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
