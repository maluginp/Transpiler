package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrIf
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrIf(private val el: TrIf) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
