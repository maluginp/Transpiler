package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprWhenEntryCondition
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprWhenEntryCondition(private val el: TrExprWhenEntryCondition) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
