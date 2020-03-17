package ru.maluginp.transpiler.core

interface TrCompanionObject: TrElement {
    val name: String
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}