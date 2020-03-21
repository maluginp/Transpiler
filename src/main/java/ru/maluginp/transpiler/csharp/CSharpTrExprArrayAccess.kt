package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprArrayAccess

class CSharpTrExprArrayAccess(private val el: TrExprArrayAccess): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}