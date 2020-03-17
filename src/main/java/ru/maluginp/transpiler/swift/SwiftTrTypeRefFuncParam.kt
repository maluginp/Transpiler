package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRefFuncParam

class SwiftTrTypeRefFuncParam(private val el: TrTypeRefFuncParam) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
