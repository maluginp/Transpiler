package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprArrayAccess
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprArrayAccess(private val el: TrExprArrayAccess) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
