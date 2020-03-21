package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrBlock

class CSharpTrBlock(private val el: TrBlock): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}