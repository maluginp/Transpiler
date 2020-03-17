package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrImport

class SwiftTrImport(private val el: TrImport) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
