package ru.maluginp.transpiler.core

interface TrExprObject: TrElement {
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}