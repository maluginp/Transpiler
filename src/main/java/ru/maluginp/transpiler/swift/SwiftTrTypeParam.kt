package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrTypeParam

class SwiftTrTypeParam(private val el: TrTypeParam) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
