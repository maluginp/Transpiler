package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrTry

class SwiftTrTry(private val el: TrTry) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
