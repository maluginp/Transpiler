package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrValueArg

class SwiftTrValueArg(private val el: TrValueArg) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
