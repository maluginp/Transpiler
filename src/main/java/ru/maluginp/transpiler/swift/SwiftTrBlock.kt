package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrBlock
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrBlock(private val el: TrBlock): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
