package ru.maluginp.transpiler.convertors

interface IGenerator {
    fun formatPackage(packageName: String): String
    fun formatImport(packageName: String): String
    fun formatEnum(name: String): String
    fun formatIf(expr: String, body: String, elseBody: String?): String
}

class BaseGenerator: IGenerator {
    override fun formatPackage(packageName: String): String {
        return "package $packageName"
    }

    override fun formatImport(packageName: String): String {
        return "import $packageName"
    }

    override fun formatEnum(name: String): String {
        return "enum $name"
    }

    override fun formatIf(expr: String, body: String, elseBody: String?): String {
        return "if ($expr)$body" + (elseBody?.let { " else$elseBody" } ?: "")
    }
}