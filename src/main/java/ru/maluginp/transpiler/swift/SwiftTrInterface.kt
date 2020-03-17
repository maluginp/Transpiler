package ru.maluginp.transpiler.swift

import org.jetbrains.kotlin.utils.addToStdlib.ifNotEmpty
import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrInterface
import ru.maluginp.transpiler.core.TrMember
import ru.maluginp.transpiler.core.TrParent


class SwiftTrEmpty: TrImplementation {
    override fun output(): String = ""
}

class SwiftTrInterface(private val el: TrInterface): TrImplementation {
    override fun output(): String {
        var text =  "protocol ${el.name}"

        text += el.parents.ifNotEmpty {
            " : ${joinToString(separator = ", ") { SwiftTrParent(it).output() }}"
        } ?: ""


        text += el.members.ifNotEmpty {
            "{\n${joinToString(separator = "\n") { SwiftTrMember(it).output() }}\n}"
        }

        return text+"\n"
    }
}

class SwiftTrMember(private val element: TrMember): TrImplementation {
    override fun output(): String = element.expr
}

class SwiftTrParent(private val element: TrParent): TrImplementation {
    override fun output(): String = element.expr
}