package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrFuncParam
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrFuncParam(private val el: TrFuncParam) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
