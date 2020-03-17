package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrBinaryOp
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrBinaryOp(private val el: TrBinaryOp): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
