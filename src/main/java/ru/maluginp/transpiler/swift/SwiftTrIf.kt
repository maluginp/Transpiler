package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrIf
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrIf(private val el: TrIf) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
