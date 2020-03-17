package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrModifierKeyword

class SwiftTrModifierKeyword(private val el: TrModifierKeyword) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
