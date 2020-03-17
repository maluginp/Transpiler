package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrAnnotation
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrAnnotation(private val el: TrAnnotation): TrImplementation {
    override fun output(): String {
        return "SwiftTrAnnotation"
    }
}
