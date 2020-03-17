package ru.maluginp.transpiler.core

data class AstTrProperty(
    override val vars: Collection<TrPropertyVar>,
    override val readOnly: Boolean,
    override val delegated: Boolean,
    override val expr: String?,
    override val receiveType: String?,
    override val typeParams: Collection<TrTypeParam>
): TrProperty