package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrEnum

class CSharpTrEnum(private val el: TrEnum): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}