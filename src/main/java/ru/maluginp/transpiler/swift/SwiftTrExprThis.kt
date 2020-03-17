package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprThis
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprThis(private val el: TrExprThis) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
