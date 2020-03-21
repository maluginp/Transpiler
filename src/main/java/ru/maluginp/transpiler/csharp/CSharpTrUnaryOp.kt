package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrUnaryOp

class CSharpTrUnaryOp(private val el: TrUnaryOp): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}