package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrPropertyVar

class SwiftTrPropertyVar(private val el: TrPropertyVar) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
