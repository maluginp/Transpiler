package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrTypeRef

class SwiftTrTypeRef(private val el: TrTypeRef) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
