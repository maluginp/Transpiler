package ru.maluginp.transpiler.core

interface TrLang {
    fun format(element: TrElement): String
}