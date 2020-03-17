package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprWhen
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprWhen(private val el: TrExprWhen) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
