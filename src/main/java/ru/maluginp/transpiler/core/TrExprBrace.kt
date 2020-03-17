package ru.maluginp.transpiler.core

interface TrExprBrace: TrElement {
    val params: Collection<TrExprBraceParam>
    val body: TrBlock?
}