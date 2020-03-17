package ru.maluginp.transpiler.core

data class AstTrFor(
    override val exprLeft: Collection<TrPropertyVar>,
    override val exprRight: String,
    override val body: String
) : TrFor