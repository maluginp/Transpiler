package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrReturn

class SwiftTrReturn(private val el: TrReturn) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
