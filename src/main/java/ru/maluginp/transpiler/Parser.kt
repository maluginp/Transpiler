package ru.maluginp.transpiler

import kastree.ast.psi.Parser
import ru.maluginp.transpiler.core.ASTConvertor
import ru.maluginp.transpiler.swift.SwiftTranspiler
import java.io.File

class Parser {
    fun execute() {
        fun readFileDirectlyAsText(fileName: String): String
                = File(fileName).readText(Charsets.UTF_8)

        val file = Parser.parseFile(
            readFileDirectlyAsText("./src/main/java/ru/maluginp/transpiler/Sample.kt")
        )


        val convertor = ASTConvertor(SwiftTranspiler())
        val output = convertor.run(file)

        System.out.println(output)
    }
}