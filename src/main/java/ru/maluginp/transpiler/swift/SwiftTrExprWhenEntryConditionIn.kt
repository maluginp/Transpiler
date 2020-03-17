package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprWhenEntryConditionIn
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprWhenEntryConditionIn(private val el: TrExprWhenEntryConditionIn) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
