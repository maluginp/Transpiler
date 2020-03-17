package ru.maluginp.transpiler

import kastree.ast.psi.Parser
import ru.maluginp.transpiler.swift.SwiftLang
import java.io.File

class Startup {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            fun readFileDirectlyAsText(fileName: String): String = File(fileName).readText(Charsets.UTF_8)

            val file = Parser.parseFile(
                readFileDirectlyAsText("./src/main/java/ru/maluginp/transpiler/Sample.kt")
            )

            val transpiler = Transpiler(SwiftLang())
            val output = transpiler.convert(file)

            System.out.println(output)
        }
    }
}
