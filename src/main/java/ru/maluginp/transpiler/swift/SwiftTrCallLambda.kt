package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrCallLambda
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrCallLambda(private val el: TrCallLambda) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}