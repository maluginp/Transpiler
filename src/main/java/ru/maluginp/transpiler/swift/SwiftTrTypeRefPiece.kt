package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRefPiece

class SwiftTrTypeRefPiece(private val el: TrTypeRefPiece) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
