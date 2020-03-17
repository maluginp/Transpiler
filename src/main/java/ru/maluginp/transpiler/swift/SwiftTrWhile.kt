package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrWhile

class SwiftTrWhile(private val el: TrWhile) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
