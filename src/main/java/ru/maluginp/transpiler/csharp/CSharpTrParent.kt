package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrParent

class CSharpTrParent(private val el: TrParent): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
