package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRefPiece

class CSharpTrTypeRefPiece(private val el: TrTypeRefPiece): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}