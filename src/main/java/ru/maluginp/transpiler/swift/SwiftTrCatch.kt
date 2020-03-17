package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrCatch
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrCatch(private val el: TrCatch): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}