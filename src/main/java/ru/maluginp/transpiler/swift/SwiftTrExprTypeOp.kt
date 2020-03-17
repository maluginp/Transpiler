package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprTypeOp
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprTypeOp(private val el: TrExprTypeOp) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
