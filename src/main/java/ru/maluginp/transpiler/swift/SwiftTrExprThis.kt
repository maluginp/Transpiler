package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprThis
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprThis(private val el: TrExprThis) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
