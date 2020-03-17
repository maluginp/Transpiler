package ru.maluginp.transpiler.core

data class AstTrExprArrayAccess(
    override val expr: String,
    override val indices: Collection<String>
): TrExprArrayAccess