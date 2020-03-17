package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeParam

class SwiftTrTypeParam(private val el: TrTypeParam) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
