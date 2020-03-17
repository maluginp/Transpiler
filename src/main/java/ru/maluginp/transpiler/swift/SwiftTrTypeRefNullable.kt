package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRefNullable

class SwiftTrTypeRefNullable(private val el: TrTypeRefNullable) : TrImplementation {
    override fun output(): String {
        return "${el.type}?"
    }
}
