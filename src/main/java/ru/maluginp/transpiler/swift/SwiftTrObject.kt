package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrObject

class SwiftTrObject(private val el: TrObject) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
