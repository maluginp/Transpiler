package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrFor
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrFor(private val el: TrFor) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
