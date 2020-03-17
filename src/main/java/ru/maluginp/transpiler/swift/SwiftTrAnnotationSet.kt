package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrAnnotationSet
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrAnnotationSet(private val el: TrAnnotationSet): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
