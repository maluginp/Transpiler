package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.TrImplementation
import ru.maluginp.transpiler.core.TrInitBlock

class SwiftTrInitBlock(private val el: TrInitBlock) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
