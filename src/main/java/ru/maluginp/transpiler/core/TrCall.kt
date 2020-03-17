package ru.maluginp.transpiler.core

interface TrCall: TrElement {
    val expr: String
    val args: Collection<TrValueArg>
}