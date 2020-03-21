package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrFuncParam

class CSharpTrFuncParam(private val el: TrFuncParam): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}