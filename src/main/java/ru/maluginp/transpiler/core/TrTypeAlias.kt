package ru.maluginp.transpiler.core

interface TrTypeAlias: TrElement {
    val name: String
    val type: String
    val typeParams: Collection<TrTypeParam>
}