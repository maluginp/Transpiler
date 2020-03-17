package ru.maluginp.transpiler.core

interface TrWhile: TrElement {
    val expr: String
    val body: String
}