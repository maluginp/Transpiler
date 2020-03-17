package ru.maluginp.transpiler.core

data class AstTrInterface(
    override val name: String,
    override val parents: Collection<TrParent>,
    override val members: Collection<TrMember>
) : TrInterface