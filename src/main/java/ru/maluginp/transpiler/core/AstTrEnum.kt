package ru.maluginp.transpiler.core

data class AstTrEnum(
    override val name: String,
    override val args: List<TrValueArg>,
    override val members: Collection<TrMember>
): TrEnum