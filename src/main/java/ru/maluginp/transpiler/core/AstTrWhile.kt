package ru.maluginp.transpiler.core

data class AstTrWhile(
    override val expr: String,
    override val body: String
) : TrWhile