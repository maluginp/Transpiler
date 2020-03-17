package ru.maluginp.transpiler.core

interface TrCatch: TrElement {
    val name: String
    val type: String
    val block: TrBlock
}