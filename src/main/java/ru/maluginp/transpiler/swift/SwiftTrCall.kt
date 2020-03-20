package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrCall
import ru.maluginp.transpiler.core.TrImplementation

class SwiftTrCall(private val el: TrCall): TrImplementation {
    override fun output(): String {
        return "${el.expr}(${el.args.joinToString(", ") { SwiftTrValueArg(it).output() }})"
    }
}
