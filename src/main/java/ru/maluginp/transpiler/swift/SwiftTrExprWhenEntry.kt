package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprWhenEntry
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprWhenEntry(private val el: TrExprWhenEntry) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
