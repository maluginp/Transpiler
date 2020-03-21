package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrFunc
import ru.maluginp.transpiler.core.TrImplementation

class CSharpTrFunc(private val el: TrFunc): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
