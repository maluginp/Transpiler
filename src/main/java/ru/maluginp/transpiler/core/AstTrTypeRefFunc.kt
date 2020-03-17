package ru.maluginp.transpiler.core

data class AstTrTypeRefFunc(
    override val type: String,
    override val params: Collection<TrTypeRefFuncParam>,
    override val receiveType: String
): TrTypeRefFunc