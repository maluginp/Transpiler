package ru.maluginp.transpiler.core

data class AstTrAnnotationSet(
    override val targetName: String?,
    override val annotations: Collection<TrAnnotation>
): TrAnnotationSet