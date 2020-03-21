package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrMember

class CSharpTrMember(private val el: TrMember): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}