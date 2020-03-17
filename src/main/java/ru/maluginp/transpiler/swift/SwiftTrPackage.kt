package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrPackage

class SwiftTrPackage(private val el: TrPackage) : TrImplementation {
    override fun output(): String {
        return "package ${el.name}"
    }
}
