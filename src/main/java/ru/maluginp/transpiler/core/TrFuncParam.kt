package ru.maluginp.transpiler.core

interface TrFuncParam: TrElement {
    val name: String
    val type: String?
    val default: String?
    val readOnly: Boolean?
}