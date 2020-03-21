package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrIf
import ru.maluginp.transpiler.core.TrImplementation

class CSharpTrIf(private val el: TrIf): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
