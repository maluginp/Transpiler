package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrThrow

class SwiftTrThrow(private val el: TrThrow) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
