package ru.maluginp.transpiler.core

interface TrEnum: TrElement {
    val name: String
    val args: List<TrValueArg>
    val members: Collection<TrMember>
}