package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprWhen

class CSharpTrExprWhen(private val el: TrExprWhen): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}