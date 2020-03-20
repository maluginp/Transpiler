package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrPropertyVar

class SwiftTrPropertyVar(private val el: TrPropertyVar) : TrImplementation {
    override fun output(): String {
        return "${el.name}${type(el.type)}"
    }

    private fun type(type: String?): String {
        return type?.let { if (it.isNotEmpty()) ": $it" else "" } ?: ""
    }
}
