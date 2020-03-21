package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrWhile

class CSharpTrWhile(private val el: TrWhile): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
