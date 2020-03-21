package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrPackage

class CSharpTrPackage(private val el: TrPackage): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
