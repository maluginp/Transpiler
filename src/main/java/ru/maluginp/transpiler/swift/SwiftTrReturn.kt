package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrReturn

class SwiftTrReturn(private val el: TrReturn) : TrImplementation {
    override fun output(): String {
        return "return ${el.expr}"
    }
}
