package ru.maluginp.transpiler.core

interface TrCallLambda: TrElement {
    val expr: String
    val args: Collection<TrValueArg>
    val lambda: String
}