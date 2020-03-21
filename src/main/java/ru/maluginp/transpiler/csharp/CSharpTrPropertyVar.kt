package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrPropertyVar

class CSharpTrPropertyVar(private val el: TrPropertyVar): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}