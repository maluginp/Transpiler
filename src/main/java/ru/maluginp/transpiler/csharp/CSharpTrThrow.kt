package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrThrow

class CSharpTrThrow(private val el: TrThrow): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
