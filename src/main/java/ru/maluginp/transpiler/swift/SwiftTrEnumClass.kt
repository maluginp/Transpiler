package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrEnumClass
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrEnumClass(private val el: TrEnumClass) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
