package ru.maluginp.transpiler.core

data class AstTrExprBrace(
    override val params: Collection<TrExprBraceParam>,
    override val body: TrBlock?
): TrExprBrace