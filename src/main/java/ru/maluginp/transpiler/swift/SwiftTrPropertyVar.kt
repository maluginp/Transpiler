package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrPropertyVar

class SwiftTrPropertyVar(private val el: TrPropertyVar) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
