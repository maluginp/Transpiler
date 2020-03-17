package ru.maluginp.transpiler.core

data class AstTrFuncParam (
    override val name: String,
    override val type: String?,
    override val default: String?,
    override val readOnly: Boolean?
): TrFuncParam