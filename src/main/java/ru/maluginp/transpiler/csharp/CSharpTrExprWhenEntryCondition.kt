package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprWhenEntryCondition

class CSharpTrExprWhenEntryCondition(private val el: TrExprWhenEntryCondition): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}