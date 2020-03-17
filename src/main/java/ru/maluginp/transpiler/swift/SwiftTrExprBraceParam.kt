package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprBraceParam
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprBraceParam(private val el: TrExprBraceParam) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
