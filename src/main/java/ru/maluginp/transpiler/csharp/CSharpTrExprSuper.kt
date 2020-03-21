package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprSuper

class CSharpTrExprSuper(private val el: TrExprSuper): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}