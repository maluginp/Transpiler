package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrAnnotationSet
import ru.maluginp.transpiler.convertors.TrImplementation

class SwiftTrAnnotationSet(private val el: TrAnnotationSet): TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
