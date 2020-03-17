package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrFunc
import ru.maluginp.transpiler.core.TrFuncParam
import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrModifier

class SwiftTrFunc(private val el: TrFunc) : TrImplementation {
    override fun output(): String {
        return "${modifiers(el.modifiers)} func ${el.name}${params(el.params)} -> ${el.returnType} ${body(el.body)}"
    }

    private fun modifiers(mods: Collection<TrModifier>): String {
        return mods.joinToString(" ") { SwiftTrModifier(it).output() }
    }

    private fun params(params: Collection<TrFuncParam>): String {
        return "(${params.joinToString(", ") { SwiftTrFuncParam(it).output() } })"
    }

    private fun body(body: String?): String {
        return body?.let {
            "{ $it }"
        } ?: ""
    }
}
