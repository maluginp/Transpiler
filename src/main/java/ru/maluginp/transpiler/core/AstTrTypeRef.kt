package ru.maluginp.transpiler.core

data class AstTrTypeRef(
    override val pieces: Collection<TrTypeRefPiece>
): TrTypeRef