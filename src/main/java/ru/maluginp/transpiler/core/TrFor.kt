package ru.maluginp.transpiler.core

interface TrFor : TrElement {
    val exprLeft: Collection<TrPropertyVar>
    val exprRight: String
    val body: String
}