package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrProperty

class SwiftTrProperty(private val el: TrProperty) : TrImplementation {
    override fun output(): String {
        return "${readOnly(el.readOnly)} ${el.vars.joinToString(", ") { SwiftTrPropertyVar(it).output() }}${expr(el.expr)}"
    }

    private fun expr(expr: String?): String {
        return expr?.let{
            " = $it"
        } ?: ""
    }

    private fun readOnly(readOnly: Boolean): String {
        return if (readOnly) {
            "let"
        } else {
            "var"
        }
    }
}
