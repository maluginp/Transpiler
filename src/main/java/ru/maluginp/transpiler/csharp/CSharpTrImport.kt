package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrImport

class CSharpTrImport(private val el: TrImport): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
