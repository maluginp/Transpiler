package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprBrace

class CSharpTrExprBrace(private val el: TrExprBrace): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}