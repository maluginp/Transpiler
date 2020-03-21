package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation

class CSharpTrEmpty: TrImplementation {
    override fun output(): String {
        return ""
    }
}
