package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrInterface

class CSharpTrInterface(private val el: TrInterface): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
