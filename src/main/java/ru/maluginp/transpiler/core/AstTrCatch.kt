package ru.maluginp.transpiler.core

data class AstTrCatch(
    override val name: String,
    override val type: String,
    override val block: TrBlock
): TrCatch