package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrThrow

class SwiftTrThrow(private val el: TrThrow) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
