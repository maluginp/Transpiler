package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrCompanionObject
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrCompanionObject(private val el: TrCompanionObject) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
