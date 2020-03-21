package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrAnnotation

class CSharpTrAnnotation(private val el: TrAnnotation): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}