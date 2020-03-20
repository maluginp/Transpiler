package ru.maluginp.transpiler.swift

import org.jetbrains.kotlin.utils.addToStdlib.ifNotEmpty
import ru.maluginp.transpiler.core.TrFor
import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrPropertyVar

class SwiftTrFor(private val el: TrFor) : TrImplementation {
    override fun output(): String {
        /*
        for day in days {
  print(day)
}
         */
        return "for ${left(el.exprLeft)} in ${el.exprRight}${body(el.body)}"
    }

    private fun body(body: String): String {
        return "{\n$body\n}"
    }

    private fun left(exprs: Collection<TrPropertyVar>): String {
        return exprs.ifNotEmpty {
            joinToString(", ") { SwiftTrPropertyVar(it).output() }
        } ?: ""
    }
}
