package ru.maluginp.transpiler.core

interface TrExprArrayAccess: TrElement {
    val expr: String
    val indices: Collection<String>
}