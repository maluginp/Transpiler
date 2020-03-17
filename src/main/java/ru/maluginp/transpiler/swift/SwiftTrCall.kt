package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrCall
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrCall(private val el: TrCall): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
