package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrProperty

class SwiftTrProperty(private val el: TrProperty) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
