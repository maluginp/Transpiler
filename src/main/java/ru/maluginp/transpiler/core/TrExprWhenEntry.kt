package ru.maluginp.transpiler.core

interface TrExprWhenEntry: TrElement {
    val conditions: Collection<TrExprWhenEntryCondition>
    val expr: String
}