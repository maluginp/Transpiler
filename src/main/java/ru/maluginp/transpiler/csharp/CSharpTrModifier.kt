package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrModifier

class CSharpTrModifier(private val el: TrModifier): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}