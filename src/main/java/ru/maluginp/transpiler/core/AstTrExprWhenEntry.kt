package ru.maluginp.transpiler.core

data class AstTrExprWhenEntry(
    override val conditions: Collection<TrExprWhenEntryCondition>,
    override val expr: String
): TrExprWhenEntry