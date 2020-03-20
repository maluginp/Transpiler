package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrModifierKeyword

class SwiftTrModifierKeyword(private val el: TrModifierKeyword) : TrImplementation {
    override fun output(): String {
        return "" //el.keyword.name
    }
}
