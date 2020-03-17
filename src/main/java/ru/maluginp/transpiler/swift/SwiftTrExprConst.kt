package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprConst
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprConst(private val el: TrExprConst) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
