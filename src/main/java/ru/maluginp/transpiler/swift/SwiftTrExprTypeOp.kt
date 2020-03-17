package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprTypeOp
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprTypeOp(private val el: TrExprTypeOp) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
