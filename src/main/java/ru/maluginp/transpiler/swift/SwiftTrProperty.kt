package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrProperty

class SwiftTrProperty(private val el: TrProperty) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
