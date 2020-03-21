package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrModifierKeyword

class CSharpTrModifierKeyword(private val el: TrModifierKeyword): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}