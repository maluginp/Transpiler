package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrFunc
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrFunc(private val el: TrFunc) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
