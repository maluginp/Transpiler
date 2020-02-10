package ru.maluginp.transpiler

import kastree.ast.psi.Parser
import ru.maluginp.transpiler.convertors.ASTConvertor
import ru.maluginp.transpiler.convertors.BaseGenerator
import java.io.File

class Parser {
    fun execute() {
        fun readFileDirectlyAsText(fileName: String): String
                = File(fileName).readText(Charsets.UTF_8)

        val file = Parser.parseFile(
            readFileDirectlyAsText("/Users/pmalyugin/Developer/Startups/Transpiler/src/main/java/ru/maluginp/transpiler/Sample.kt")
        )


        val convertor = ASTConvertor(BaseGenerator())
        val output = convertor.run(file)

        System.out.println(output)
    }
}