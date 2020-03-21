package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprProperty

class CSharpTrExprProperty(private val el: TrExprProperty): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}