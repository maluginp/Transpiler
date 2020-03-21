package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrStatement

class CSharpTrStatement(private val el: TrStatement): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}