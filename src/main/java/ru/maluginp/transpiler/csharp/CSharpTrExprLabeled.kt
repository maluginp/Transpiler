package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprLabeled

class CSharpTrExprLabeled(private val el: TrExprLabeled): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}