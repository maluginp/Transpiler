package ru.maluginp.transpiler.swift

import org.jetbrains.kotlin.utils.addToStdlib.ifNotEmpty
import ru.maluginp.transpiler.core.TrBlock
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrBlock(private val el: TrBlock) : TrImplementation {
    override fun output(): String {
        return el.statements.ifNotEmpty { "\n ${joinToString("\n") { SwiftTrStatement(it).output() }}\n" } ?: ""
    }
}
