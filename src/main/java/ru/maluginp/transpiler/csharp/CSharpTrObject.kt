package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrObject

class CSharpTrObject(private val el: TrObject): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}