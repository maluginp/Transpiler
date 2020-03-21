package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprBreak

class CSharpTrExprBreak(private val el: TrExprBreak): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}