package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrBinaryOp
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrBinaryOp(private val el: TrBinaryOp): TrImplementation {
    override fun output(): String {
        return "${el.left}${el.op}${el.right}"
    }
}
