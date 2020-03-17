package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrTypeRefNullable

class SwiftTrTypeRefNullable(private val el: TrTypeRefNullable) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
