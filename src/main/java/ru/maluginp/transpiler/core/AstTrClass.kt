package ru.maluginp.transpiler.core

data class AstTrClass(
    override val name: String,
    override val parents: Collection<TrParent>,
    override val members: Collection<TrMember>
): TrClass