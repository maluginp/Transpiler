package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprCollLit

class CSharpTrExprCollLit(private val el: TrExprCollLit): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}