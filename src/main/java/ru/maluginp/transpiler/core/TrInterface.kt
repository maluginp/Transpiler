package ru.maluginp.transpiler.core

interface TrInterface: TrElement {
    val name: String
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}