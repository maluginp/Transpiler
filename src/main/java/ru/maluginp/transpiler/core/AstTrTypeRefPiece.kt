package ru.maluginp.transpiler.core

data class AstTrTypeRefPiece(
    override val name: String,
    override val typeParams: Collection<String>
): TrTypeRefPiece