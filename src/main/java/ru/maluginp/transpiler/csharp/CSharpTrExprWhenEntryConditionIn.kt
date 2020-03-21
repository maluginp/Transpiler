package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprWhenEntryConditionIn

class CSharpTrExprWhenEntryConditionIn(private val el: TrExprWhenEntryConditionIn): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}