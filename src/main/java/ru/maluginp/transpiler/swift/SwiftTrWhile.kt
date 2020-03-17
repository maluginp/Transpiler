package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrWhile

class SwiftTrWhile(private val el: TrWhile) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
