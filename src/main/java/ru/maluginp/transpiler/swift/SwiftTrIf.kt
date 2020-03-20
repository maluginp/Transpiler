package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrIf
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrIf(private val el: TrIf) : TrImplementation {
    override fun output(): String {
        return "if ${el.expr}${body(el.body)}${elseBody(el.elseBody)}"
    }

    private fun elseBody(expr: String?): String {
        return expr?.let{" else {\n$it\n}"} ?: ""
    }

    private fun body(expr: String): String {
        return " {\n$expr\n}"
    }
}
