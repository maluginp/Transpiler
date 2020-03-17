package ru.maluginp.transpiler.core

data class AstTrExprObject(
    override val parents: Collection<TrParent>,
    override val members: Collection<TrMember>
): TrExprObject