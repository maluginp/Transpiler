package ru.maluginp.transpiler.core

interface TrFunc: TrElement {
    val name: String?
    val params: Collection<TrFuncParam>
    val returnType: String
    val modifiers: Collection<TrModifier>
    val body: String?
}