package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrCallLambda
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrCallLambda(private val el: TrCallLambda) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}