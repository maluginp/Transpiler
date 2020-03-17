package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrClass
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrClass(private val el: TrClass) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
