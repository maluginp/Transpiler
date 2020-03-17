package ru.maluginp.transpiler.core

interface TrTry: TrElement {
    val block: TrBlock
    val catches: Collection<TrCatch>
    val finallyBlock: TrBlock?
}