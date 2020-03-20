package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrStatement

class SwiftTrStatement(private val el: TrStatement) : TrImplementation {
    override fun output(): String {
        return el.expr
    }
}
