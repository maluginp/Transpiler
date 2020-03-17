package ru.maluginp.transpiler.core

data class AstTrCallLambda(
    override val expr: String,
    override val args: Collection<TrValueArg>,
    override val lambda: String
): TrCallLambda