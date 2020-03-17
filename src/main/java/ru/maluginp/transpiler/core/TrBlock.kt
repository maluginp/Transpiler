package ru.maluginp.transpiler.core

interface TrBlock: TrElement {
    val statements: Collection<TrStatement>
}