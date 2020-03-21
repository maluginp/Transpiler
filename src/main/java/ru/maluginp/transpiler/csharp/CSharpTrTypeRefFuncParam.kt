package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRefFuncParam

class CSharpTrTypeRefFuncParam(private val el: TrTypeRefFuncParam): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}