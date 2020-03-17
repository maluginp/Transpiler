package ru.maluginp.transpiler.core

data class AstTrTypeRefFuncParam(
    override val name: String?,
    override val type: String
): TrTypeRefFuncParam