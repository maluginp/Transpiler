package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrCompanionObject

class CSharpTrCompanionObject(private val el: TrCompanionObject): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}