package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprWhenEntry

class CSharpTrExprWhenEntry(private val el: TrExprWhenEntry): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}