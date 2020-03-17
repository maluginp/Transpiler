package ru.maluginp.transpiler.core

data class AstTrTypeParam(
    override val name: String,
    override val type: String
): TrTypeParam