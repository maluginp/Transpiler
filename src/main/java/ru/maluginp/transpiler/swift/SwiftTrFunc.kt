package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrFunc
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrFunc(private val el: TrFunc) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
