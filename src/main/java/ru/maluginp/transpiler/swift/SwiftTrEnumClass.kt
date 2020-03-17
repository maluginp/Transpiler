package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrEnumClass
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrEnumClass(private val el: TrEnumClass) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
