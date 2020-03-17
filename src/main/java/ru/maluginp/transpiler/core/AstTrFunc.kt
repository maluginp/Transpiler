package ru.maluginp.transpiler.core

data class AstTrFunc(
    override val name: String?,
    override val params: Collection<TrFuncParam>,
    override val returnType: String,
    override val modifiers: Collection<TrModifier>,
    override val body: String?
): TrFunc