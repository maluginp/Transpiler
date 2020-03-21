package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrEnumClass

class CSharpTrEnumClass(private val el: TrEnumClass): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}