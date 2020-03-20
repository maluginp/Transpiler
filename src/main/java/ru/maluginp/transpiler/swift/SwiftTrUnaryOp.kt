package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrUnaryOp

class SwiftTrUnaryOp(private val el: TrUnaryOp) : TrImplementation {
    override fun output(): String {
        return if (el.prefix) {
            "${operator(el.op)}${el.expr}"
        } else {
            "${el.expr}${operator(el.op)}"
        }
    }

    private fun operator(op: String): String {
        return if (op == "!!") {
            ""
        } else {
            op
        }
    }
}
