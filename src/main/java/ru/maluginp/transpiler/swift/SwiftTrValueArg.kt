package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrValueArg

class SwiftTrValueArg(private val el: TrValueArg) : TrImplementation {
    override fun output(): String {
        return "${name(el.name)}${el.expr}"
    }

    private fun name(name: String?): String {
        return name?.let { "$it: " } ?: ""
    }
}
