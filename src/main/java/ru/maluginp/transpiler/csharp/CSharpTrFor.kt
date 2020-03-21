package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrFor
import ru.maluginp.transpiler.core.TrImplementation

class CSharpTrFor(private val el: TrFor): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}