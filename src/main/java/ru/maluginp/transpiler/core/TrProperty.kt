package ru.maluginp.transpiler.core

interface TrProperty: TrElement {
    val vars: Collection<TrPropertyVar>
    val readOnly: Boolean
    val delegated: Boolean
    val expr: String?
    val receiveType: String?
    val typeParams: Collection<TrTypeParam>
}