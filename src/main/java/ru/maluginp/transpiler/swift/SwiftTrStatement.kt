package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrStatement

class SwiftTrStatement(private val el: TrStatement) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
