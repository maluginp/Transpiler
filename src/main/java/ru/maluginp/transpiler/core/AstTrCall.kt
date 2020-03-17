package ru.maluginp.transpiler.core

data class AstTrCall(
    override val expr: String,
    override val args: Collection<TrValueArg>
): TrCall