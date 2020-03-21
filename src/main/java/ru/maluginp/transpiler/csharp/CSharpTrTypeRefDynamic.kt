package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRefDynamic

class CSharpTrTypeRefDynamic(private val el: TrTypeRefDynamic): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}