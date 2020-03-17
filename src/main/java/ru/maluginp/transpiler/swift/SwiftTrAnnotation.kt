package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrAnnotation
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrAnnotation(private val el: TrAnnotation): TrImplementation {
    override fun output(): String {
        return "SwiftTrAnnotation"
    }
}
