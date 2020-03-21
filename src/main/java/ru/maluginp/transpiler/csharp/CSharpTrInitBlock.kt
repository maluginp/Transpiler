package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrInitBlock

class CSharpTrInitBlock(private val el: TrInitBlock): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}