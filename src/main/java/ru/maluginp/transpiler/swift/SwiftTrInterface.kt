package ru.maluginp.transpiler.swift

import org.jetbrains.kotlin.utils.addToStdlib.ifNotEmpty
import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrInterface
import ru.maluginp.transpiler.convertors.TrMember
import ru.maluginp.transpiler.convertors.TrParent


class SwiftTrEmpty: TrImplementation {
    override fun output(): String = ""
}

class SwiftTrInterface(private val element: TrInterface): TrImplementation {
    override fun output(): String {
        var text =  "protocol ${element.name}"

        text += element.parents.ifNotEmpty {
            " : ${joinToString(separator = ", ") { SwiftTrParent(it).output() }}"
        } ?: ""


        text += element.members.ifNotEmpty {
            """
                {
                  ${joinToString(separator = "\n") { SwiftTrMember(it).output() }}
                }
                
            """.trimIndent()
        }

        return text
    }
}

class SwiftTrMember(private val element: TrMember): TrImplementation {
    override fun output(): String = element.expr
}

class SwiftTrParent(private val element: TrParent): TrImplementation {
    override fun output(): String = element.expr
}