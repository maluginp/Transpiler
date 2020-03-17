package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRefFunc

class SwiftTrTypeRefFunc(private val el: TrTypeRefFunc) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
