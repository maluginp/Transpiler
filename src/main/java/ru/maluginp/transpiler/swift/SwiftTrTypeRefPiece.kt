package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrTypeRefPiece

class SwiftTrTypeRefPiece(private val el: TrTypeRefPiece) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
