package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprWhenEntryConditionIs

class CSharpTrExprWhenEntryConditionIs(private val el: TrExprWhenEntryConditionIs): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}