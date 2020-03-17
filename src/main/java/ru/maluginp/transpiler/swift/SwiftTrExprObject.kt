package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrExprObject
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrExprObject(private val el: TrExprObject) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
