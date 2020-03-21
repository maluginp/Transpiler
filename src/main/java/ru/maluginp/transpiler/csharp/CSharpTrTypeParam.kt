package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeParam

class CSharpTrTypeParam(private val el: TrTypeParam): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}