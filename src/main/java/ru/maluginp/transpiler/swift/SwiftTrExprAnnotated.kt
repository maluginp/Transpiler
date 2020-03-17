package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprAnnotated
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprAnnotated(private val el: TrExprAnnotated) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
