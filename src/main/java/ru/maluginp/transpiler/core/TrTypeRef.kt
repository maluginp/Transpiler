package ru.maluginp.transpiler.core

interface TrTypeRef: TrElement {
    val pieces: Collection<TrTypeRefPiece>
}