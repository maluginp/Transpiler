package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprBraceParam

class CSharpTrExprBraceParam(private val el: TrExprBraceParam): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}