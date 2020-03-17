package ru.maluginp.transpiler.core

interface TrAnnotation: TrElement {
    val args: Collection<TrValueArg>
    val names: Collection<String>
    val typeArgs: Collection<String>
}