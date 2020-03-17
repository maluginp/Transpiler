package ru.maluginp.transpiler.core

interface TrUnaryOp: TrElement {
    val prefix: Boolean
    val expr: String
    val op: String
}