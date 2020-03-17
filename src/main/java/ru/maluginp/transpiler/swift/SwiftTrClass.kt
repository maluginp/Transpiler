package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrClass
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrClass(private val el: TrClass) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
