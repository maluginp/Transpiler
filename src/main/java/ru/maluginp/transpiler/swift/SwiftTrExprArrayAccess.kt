package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprArrayAccess
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprArrayAccess(private val el: TrExprArrayAccess) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
