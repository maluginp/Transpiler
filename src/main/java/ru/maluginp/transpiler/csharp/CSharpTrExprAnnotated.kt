package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprAnnotated

class CSharpTrExprAnnotated(private val el: TrExprAnnotated): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}