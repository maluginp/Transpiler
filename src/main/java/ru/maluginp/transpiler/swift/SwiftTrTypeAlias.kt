package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrTypeAlias

class SwiftTrTypeAlias(private val el: TrTypeAlias) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
