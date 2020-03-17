package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrBlock
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrBlock(private val el: TrBlock): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
