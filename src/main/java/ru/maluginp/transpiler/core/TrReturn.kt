package ru.maluginp.transpiler.core

interface TrReturn: TrElement {
    val expr: String
    val label: String?
}