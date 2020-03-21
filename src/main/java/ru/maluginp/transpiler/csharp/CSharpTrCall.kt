package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrCall
import ru.maluginp.transpiler.core.TrImplementation

class CSharpTrCall(private val el: TrCall): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
