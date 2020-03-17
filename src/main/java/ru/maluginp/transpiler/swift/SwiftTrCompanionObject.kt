package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrCompanionObject
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrCompanionObject(private val el: TrCompanionObject) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
