package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.convertors.TrImplementation
import ru.maluginp.transpiler.convertors.TrInitBlock

class SwiftTrInitBlock(private val el: TrInitBlock) : TrImplementation {
    override fun output(): String {
        return "$el"
    }
}
