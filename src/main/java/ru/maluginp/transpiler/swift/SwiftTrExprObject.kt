package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprObject
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprObject(private val el: TrExprObject) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
