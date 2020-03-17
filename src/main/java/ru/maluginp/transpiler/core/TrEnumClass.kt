package ru.maluginp.transpiler.core

interface TrEnumClass: TrElement {
    val name: String
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}