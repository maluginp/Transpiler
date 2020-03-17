package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrTypeRefDynamic

class SwiftTrTypeRefDynamic(private val el: TrTypeRefDynamic) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
