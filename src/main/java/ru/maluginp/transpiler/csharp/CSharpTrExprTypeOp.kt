package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrExprTypeOp

class CSharpTrExprTypeOp(private val el: TrExprTypeOp): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}