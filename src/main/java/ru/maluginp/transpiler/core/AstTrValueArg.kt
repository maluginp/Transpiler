package ru.maluginp.transpiler.core

data class AstTrValueArg(
    override val name: String?,
    override val expr: String,
    override val asterisk: Boolean
): TrValueArg