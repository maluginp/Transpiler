package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrEnum
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrEnum(private val el: TrEnum) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
