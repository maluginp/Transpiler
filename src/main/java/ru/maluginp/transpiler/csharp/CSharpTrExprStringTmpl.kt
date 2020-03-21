package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprStringTmpl

class CSharpTrExprStringTmpl(private val el: TrExprStringTmpl): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}