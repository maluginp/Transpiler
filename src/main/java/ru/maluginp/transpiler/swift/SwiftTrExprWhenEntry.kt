package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprWhenEntry
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprWhenEntry(private val el: TrExprWhenEntry) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
