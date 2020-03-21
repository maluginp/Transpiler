package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprName

class CSharpTrExprName(private val el: TrExprName): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}