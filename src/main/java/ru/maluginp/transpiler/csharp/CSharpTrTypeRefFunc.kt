package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRefFunc

class CSharpTrTypeRefFunc(private val el: TrTypeRefFunc): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}