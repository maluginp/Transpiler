package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrCatch
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrCatch(private val el: TrCatch): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}