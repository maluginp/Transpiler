package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprContinue

class CSharpTrExprContinue(private val el: TrExprContinue): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}