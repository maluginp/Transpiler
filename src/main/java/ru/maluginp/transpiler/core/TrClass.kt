package ru.maluginp.transpiler.core

interface TrClass: TrElement {
    val name: String
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}