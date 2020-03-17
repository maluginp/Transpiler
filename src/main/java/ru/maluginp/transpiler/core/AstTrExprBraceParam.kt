package ru.maluginp.transpiler.core

data class AstTrExprBraceParam(
    override val destructType: String?,
    override val vars: Collection<TrPropertyVar>
): TrExprBraceParam