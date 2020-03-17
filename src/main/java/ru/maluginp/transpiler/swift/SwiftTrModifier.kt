package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrModifier

class SwiftTrModifier(private val el: TrModifier) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
