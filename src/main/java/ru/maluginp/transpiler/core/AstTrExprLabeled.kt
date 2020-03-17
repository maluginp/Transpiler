package ru.maluginp.transpiler.core

data class AstTrExprLabeled(
    override val expr: String,
    override val label: String?
): TrExprLabeled