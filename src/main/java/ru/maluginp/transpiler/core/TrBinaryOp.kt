package ru.maluginp.transpiler.core

interface TrBinaryOp : TrElement {
    val left: String
    val right: String
    val op: String
}