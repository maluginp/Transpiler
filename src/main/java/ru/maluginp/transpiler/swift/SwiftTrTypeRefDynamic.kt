package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRefDynamic

class SwiftTrTypeRefDynamic(private val el: TrTypeRefDynamic) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
