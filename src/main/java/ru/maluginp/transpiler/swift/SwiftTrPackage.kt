package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrPackage

class SwiftTrPackage(private val el: TrPackage) : TrImplementation {
    override fun output(): String = ""
}
