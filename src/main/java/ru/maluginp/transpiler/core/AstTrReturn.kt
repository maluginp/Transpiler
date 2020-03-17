package ru.maluginp.transpiler.core

data class AstTrReturn(
    override val expr: String,
    override val label: String?
): TrReturn