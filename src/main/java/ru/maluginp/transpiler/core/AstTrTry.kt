package ru.maluginp.transpiler.core

data class AstTrTry(
    override val block: TrBlock,
    override val catches: Collection<TrCatch>,
    override val finallyBlock: TrBlock?
): TrTry