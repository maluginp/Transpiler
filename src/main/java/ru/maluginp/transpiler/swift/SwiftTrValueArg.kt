package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrValueArg

class SwiftTrValueArg(private val el: TrValueArg) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
