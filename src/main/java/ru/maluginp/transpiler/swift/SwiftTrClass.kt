package ru.maluginp.transpiler.swift

import org.jetbrains.kotlin.utils.addToStdlib.ifNotEmpty
import ru.maluginp.transpiler.core.TrClass
import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrMember
import ru.maluginp.transpiler.core.TrParent

class SwiftTrClass(private val el: TrClass) : TrImplementation {
    override fun output(): String {
        return "class ${el.name}${parents(el.parents)}${members(el.members)}"
    }

    private fun members(members: Collection<TrMember>): String {
        return members.ifNotEmpty {
            "{\n${joinToString("\n") { SwiftTrMember(it).output() }}\n}\n"
        } ?: ""
    }

    private fun parents(parents: Collection<TrParent>): String {
        return parents.ifNotEmpty {
            ": ${joinToString(", ") { SwiftTrParent(it).output() }} "
        } ?: ""
    }
}
