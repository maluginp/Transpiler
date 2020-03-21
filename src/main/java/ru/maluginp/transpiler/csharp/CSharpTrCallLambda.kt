package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrCallLambda
import ru.maluginp.transpiler.core.TrImplementation

class CSharpTrCallLambda(private val el: TrCallLambda): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
