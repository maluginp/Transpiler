package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTry

class CSharpTrTry(private val el: TrTry): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}