package ru.maluginp.transpiler.core

interface TrExprBraceParam: TrElement {
    val destructType: String?
    val vars: Collection<TrPropertyVar>
}