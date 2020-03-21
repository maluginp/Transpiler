package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrProperty

class CSharpTrProperty(private val el: TrProperty): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}