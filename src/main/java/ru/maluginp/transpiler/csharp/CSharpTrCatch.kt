package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrCatch

class CSharpTrCatch(private val el: TrCatch): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}