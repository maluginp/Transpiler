package ru.maluginp.transpiler.core

data class AstTrBlock(
    override val statements: Collection<TrStatement>
): TrBlock