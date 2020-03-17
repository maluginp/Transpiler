package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrImport

class SwiftTrImport(private val el: TrImport) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
