package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrUnaryOp

class SwiftTrUnaryOp(private val el: TrUnaryOp) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
