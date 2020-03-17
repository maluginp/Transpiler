package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprSuper
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprSuper(private val el: TrExprSuper) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
