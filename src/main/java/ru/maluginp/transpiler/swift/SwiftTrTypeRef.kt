package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRef

class SwiftTrTypeRef(private val el: TrTypeRef) : TrImplementation {
    override fun output(): String {
        return el.pieces.joinToString(", ") { SwiftTrTypeRefPiece(it).output() }
    }
}
