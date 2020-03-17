package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrTypeRefFunc

class SwiftTrTypeRefFunc(private val el: TrTypeRefFunc) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
