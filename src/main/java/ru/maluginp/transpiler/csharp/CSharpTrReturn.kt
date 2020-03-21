package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrReturn

class CSharpTrReturn(private val el: TrReturn): TrImplementation {
    override fun output(): String {
        return "return ${el.expr}"
    }
}