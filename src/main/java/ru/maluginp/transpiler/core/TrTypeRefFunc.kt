package ru.maluginp.transpiler.core

interface TrTypeRefFunc: TrElement {
    val type: String
    val params: Collection<TrTypeRefFuncParam>
    val receiveType: String
}