package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeAlias

class CSharpTrTypeAlias(private val el: TrTypeAlias): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}