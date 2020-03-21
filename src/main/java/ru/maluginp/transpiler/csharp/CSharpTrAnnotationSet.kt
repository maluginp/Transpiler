package ru.maluginp.transpiler.csharp

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrAnnotationSet

class CSharpTrAnnotationSet(private val el: TrAnnotationSet): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}