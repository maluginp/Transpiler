package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprWhenEntryConditionIs
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprWhenEntryConditionIs(private val el: TrExprWhenEntryConditionIs) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
