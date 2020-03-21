package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrClass
import ru.maluginp.transpiler.core.TrImplementation

class CSharpTrClass(private val el: TrClass): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
