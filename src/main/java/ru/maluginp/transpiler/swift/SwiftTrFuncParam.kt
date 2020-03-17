package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrFuncParam
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrFuncParam(private val el: TrFuncParam) : TrImplementation {
    override fun output(): String {
        return "${readOnly(el.readOnly)}${el.name}${type(el.type)}${default(el.default)}"
    }

    private fun readOnly(readOnly: Boolean?): String {
        return readOnly?.let { if (it) "val " else "var " } ?: ""
    }

    private fun default(default: String?): String {
        return default?.let { if (it.isNotEmpty()) "=$it" else "" } ?: ""
    }

    private fun type(type: String?): String {
        return type?.let { ": $it" } ?: ""
    }
}
