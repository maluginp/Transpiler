package ru.maluginp.transpiler.core

data class AstTrAnnotation(
    override val args: Collection<TrValueArg>,
    override val names: Collection<String>,
    override val typeArgs: Collection<String>
): TrAnnotation