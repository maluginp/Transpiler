package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrBinaryOp
import ru.maluginp.transpiler.core.TrImplementation

class CSharpTrBinaryOp(private val el: TrBinaryOp): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
