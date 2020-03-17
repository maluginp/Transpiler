package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrExprBraceParam
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrExprBraceParam(private val el: TrExprBraceParam) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
