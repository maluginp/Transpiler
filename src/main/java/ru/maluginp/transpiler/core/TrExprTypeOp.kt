package ru.maluginp.transpiler.core

interface TrExprTypeOp: TrElement {
    val expr: String
    val op: String
    val type: String
}