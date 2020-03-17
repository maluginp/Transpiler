package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTry

class SwiftTrTry(private val el: TrTry) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
