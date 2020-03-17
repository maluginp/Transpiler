package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeAlias

class SwiftTrTypeAlias(private val el: TrTypeAlias) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
