package ru.maluginp.transpiler.core

interface TrObject: TrElement {
    val name: String
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}