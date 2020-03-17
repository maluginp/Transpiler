package ru.maluginp.transpiler.core

data class AstTrTypeAlias(
    override val name: String,
    override val type: String,
    override val typeParams: Collection<TrTypeParam>
): TrTypeAlias