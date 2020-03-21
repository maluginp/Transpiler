package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprThis

class CSharpTrExprThis(private val el: TrExprThis): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}