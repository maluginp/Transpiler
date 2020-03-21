package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprConst

class CSharpTrExprConst(private val el: TrExprConst): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}