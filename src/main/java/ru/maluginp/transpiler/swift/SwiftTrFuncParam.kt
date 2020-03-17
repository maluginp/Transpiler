package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrFuncParam
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrFuncParam(private val el: TrFuncParam) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
