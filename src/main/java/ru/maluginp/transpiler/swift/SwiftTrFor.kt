package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrFor
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrFor(private val el: TrFor) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
