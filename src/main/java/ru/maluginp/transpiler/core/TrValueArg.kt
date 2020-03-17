package ru.maluginp.transpiler.core

interface TrValueArg: TrElement {
    val name: String?
    val expr: String
    val asterisk: Boolean
}