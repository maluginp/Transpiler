package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrEnum
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrEnum(private val el: TrEnum) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
