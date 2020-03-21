package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRefNullable

class CSharpTrTypeRefNullable(private val el: TrTypeRefNullable): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}