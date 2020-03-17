package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrObject

class SwiftTrObject(private val el: TrObject) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
