package ru.maluginp.transpiler.core

data class AstTrPropertyVar(
    override val type: String,
    override val name: String
): TrPropertyVar