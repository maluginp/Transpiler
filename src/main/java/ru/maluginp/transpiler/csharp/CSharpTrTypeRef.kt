package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRef

class CSharpTrTypeRef(private val el: TrTypeRef): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}