package ru.maluginp.transpiler.swift

import org.jetbrains.kotlin.utils.addToStdlib.ifNotEmpty
import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrTypeRefPiece

class SwiftTrTypeRefPiece(private val el: TrTypeRefPiece) : TrImplementation {
    override fun output(): String {
        return "${swiftType(el.name)}${paramsType(el.typeParams)}"
    }

    private fun swiftType(name: String): String {
        return when(name) {
            "Boolean" -> "Bool"
            "List" -> "Array"
            else -> name
        }
    }

    private fun paramsType(typeParams: Collection<String>): String {
        return typeParams.ifNotEmpty {
            "<${joinToString(", ") { it }}>"
        } ?: ""
    }
}
