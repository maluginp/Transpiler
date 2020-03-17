package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprConst
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprConst(private val el: TrExprConst) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
