package ru.maluginp.transpiler.core

interface TrIf : TrElement {
    val expr: String
    val body: String
    val elseBody: String?
}