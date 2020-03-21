package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrValueArg

class CSharpTrValueArg(private val el: TrValueArg): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}