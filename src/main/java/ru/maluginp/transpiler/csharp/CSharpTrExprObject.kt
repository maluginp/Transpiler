package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprObject

class CSharpTrExprObject(private val el: TrExprObject): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}