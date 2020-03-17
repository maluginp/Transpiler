package ru.maluginp.transpiler.core

data class AstTrExprWhen(
    override val expr: String?,
    override val entries: Collection<TrExprWhenEntry>
): TrExprWhen