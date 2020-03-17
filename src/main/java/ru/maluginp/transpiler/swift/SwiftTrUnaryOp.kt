package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrUnaryOp

class SwiftTrUnaryOp(private val el: TrUnaryOp) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
