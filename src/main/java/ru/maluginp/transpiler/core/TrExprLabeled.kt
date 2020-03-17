package ru.maluginp.transpiler.core

interface TrExprLabeled: TrElement {
    val expr: String
    val label: String?
}