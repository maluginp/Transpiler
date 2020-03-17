package ru.maluginp.transpiler.core

interface TrExprWhen: TrElement {
    val expr: String?
    val entries: Collection<TrExprWhenEntry>
}