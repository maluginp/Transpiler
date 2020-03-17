package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrTypeRefFuncParam

class SwiftTrTypeRefFuncParam(private val el: TrTypeRefFuncParam) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
