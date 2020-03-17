package ru.maluginp.transpiler.core

interface TrTypeRefPiece: TrElement {
    val name: String
    val typeParams: Collection<String>
}