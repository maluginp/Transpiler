package ru.maluginp.transpiler.core

interface TrAnnotationSet: TrElement {
    val targetName: String?
    val annotations: Collection<TrAnnotation>
}