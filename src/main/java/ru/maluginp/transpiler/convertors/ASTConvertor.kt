package ru.maluginp.transpiler.convertors

import kastree.ast.Node
import kastree.ast.Node.Decl.Structured.*
import kastree.ast.Node.Modifier.Keyword.*
import kotlin.math.exp

class ASTConvertor(val generator: IGenerator) {
    var ident = 0

    fun run(file: Node.File): String {
        var output = ""

        output += file.pkg?.let { pkg ->
            val packageName = pkg.names
                .map { it }
                .joinToString(separator = ".") { it }

            wrapIfNotEmpty(generator.formatPackage(packageName))
        } ?: ""

        output += file.imports.map { import ->
            val packageName:String = import.names
                .map { it }
                .joinToString(separator = ".") { it }

            wrapIfNotEmpty(generator.formatImport(packageName))
        }.joinToString(separator = "") { it }

//        output += "\n"

        output += file.decls.map {
            declare(it)
        }.joinToString(separator = "") { it }

        return output
    }

    private fun wrapIfNotEmpty(text: String, endText: String = "\n"): String {
        return if (text.isNotEmpty()) {
            text + endText
        } else {
            ""
        }
    }

    private fun declare(decl: Node.Decl): String {
        return when (decl) {
            is Node.Decl.Structured -> declareStructured(decl)
            is Node.Decl.Property -> declareProperty(decl)
            is Node.Decl.Func -> declareFunc(decl)
            is Node.Decl.EnumEntry -> declareEnum(decl)
            is Node.Decl.Init -> declareInit(decl)
            is Node.Decl.TypeAlias -> declareTypeAlias(decl)
            is Node.Decl.Constructor -> declareConstructor(decl)
        }
    }

    private fun declareConstructor(decl: Node.Decl.Constructor): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun declareTypeAlias(decl: Node.Decl.TypeAlias): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun declareInit(decl: Node.Decl.Init): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun declareEnum(decl: Node.Decl.EnumEntry): String {
        var declareText = ""

        declareText += generator.formatEnum(decl.name)

        // TODO: Add enum implementation

        return declareText
    }

    private fun declareModifier(decl: Node.Modifier): String {
        return when (decl) {
            is Node.Modifier.AnnotationSet -> TODO()
            is Node.Modifier.Lit -> when (decl.keyword) {
                ABSTRACT -> "abstract"
                FINAL -> "final"
                OPEN -> "open"
                ANNOTATION -> "annotation"
                SEALED -> "sealed"
                DATA -> "data"
                OVERRIDE -> "override"
                LATEINIT -> TODO()
                INNER -> TODO()
                PRIVATE -> "private"
                PROTECTED -> "protected"
                PUBLIC -> "public"
                INTERNAL -> TODO()
                IN -> TODO()
                OUT -> TODO()
                NOINLINE -> TODO()
                CROSSINLINE -> TODO()
                VARARG -> TODO()
                REIFIED -> TODO()
                TAILREC -> TODO()
                OPERATOR -> TODO()
                INFIX -> TODO()
                INLINE -> TODO()
                EXTERNAL -> TODO()
                SUSPEND -> TODO()
                CONST -> "const"
                ACTUAL -> TODO()
                EXPECT -> TODO()
            }
        }
    }

    private fun declareFunc(decl: Node.Decl.Func): String {
        var declareText = ""

        if (decl.mods.size > 0) {
            declareText += decl.mods
                .map { declareModifier(it) }
                .joinToString(separator = " ") { it }

            declareText += " "
        }

        declareText += "func ${decl.name}("

        declareText += decl.params.map {
            "${declareTypeRef(it.type?.ref)} ${it.name}"
        }.joinToString(separator = "") { it }

        declareText += "): " + declareTypeRef(decl.type?.ref)

        if (decl.body != null) {
            declareText += " {\n"
            ident++

            declareText += declareBody(decl.body)

            ident--

            declareText += "\n${withIdent()}}"
        }

        declareText += "\n"

        return declareText
    }

    private fun declareBody(body: Node.Decl.Func.Body?): String {
        return when (body) {
            is Node.Decl.Func.Body.Block -> declareBodyBlock(body)
            is Node.Decl.Func.Body.Expr -> declareBodyExpr(body)
            null -> ""
        }
    }

    private fun declareBodyExpr(body: Node.Decl.Func.Body.Expr): String {
        return declareExpr(body.expr)
    }

    private fun declareExpr(expr: Node.Expr?): String {
        return when (expr) {
            is Node.Expr.If -> {
                generator.formatIf(
                    expr = declareExpr(expr.expr),
                    body = declareExpr(expr.body),
                    elseBody = expr.elseBody?.let { declareExpr(expr.elseBody) }

                )
            }
            is Node.Expr.Try -> TODO()
            is Node.Expr.For -> {
                val vars = expr.vars.map {
                    declarePropertyVar(it)
                }.joinToString { it }
                val inExpr = declareExpr(expr.inExpr)
                var text = "for ($vars in $inExpr)"

                text += declareExpr(expr.body)
                text
            }
            is Node.Expr.While -> {
                var text = "while("
                text += declareExpr(expr.expr)
                text += ")"

                text += declareExpr(expr.body)

                return text
            }
            is Node.Expr.BinaryOp -> {
                var oper = expr.oper

                var operator: String = when (oper) {
                    is Node.Expr.BinaryOp.Oper.Infix -> oper.str
                    is Node.Expr.BinaryOp.Oper.Token -> oper.token.str
                }


                return "${declareExpr(expr.lhs)}${operator}${declareExpr(expr.rhs)}"
            }
            is Node.Expr.UnaryOp -> {
                var operator = expr.oper.token.str

                if (expr.prefix) {
                    return "$operator${declareExpr(expr.expr)}"
                } else {
                    return "${declareExpr(expr.expr)}$operator"
                }
            }
            is Node.Expr.TypeOp -> {
                var operator: String = expr.oper.token.str

                return "${declareExpr(expr.lhs)}${operator}${declareTypeRef(expr.rhs.ref)}"
            }
            is Node.Expr.DoubleColonRef.Callable -> {
                return "DoubleColonRef.Callable ${expr.name}"
            }
            is Node.Expr.DoubleColonRef.Class -> {
                return "DoubleColonRef.class"
            }
            is Node.Expr.Paren -> {
                declareExpr(expr.expr)
            }
            is Node.Expr.StringTmpl -> {
                return "\"" + expr.elems.map {
                    when (it) {
                        is Node.Expr.StringTmpl.Elem.Regular -> it.str
                        is Node.Expr.StringTmpl.Elem.ShortTmpl -> it.str
                        is Node.Expr.StringTmpl.Elem.UnicodeEsc -> it.digits
                        is Node.Expr.StringTmpl.Elem.RegularEsc -> "${it.char}"
                        is Node.Expr.StringTmpl.Elem.LongTmpl -> declareExpr(it.expr)
                    }
                }.joinToString { it } + "\""
            }
            is Node.Expr.Const -> {
                return expr.value
//                return "const ${expr.form.name} = ${expr.value}"
            }
            is Node.Expr.Brace -> {
                var text = " {\n"
                ident++
                text += withIdent(declareExprBlock(expr.block))
                ident--

                text += "\n" + withIdent("}")
                return text
            }
            is Node.Expr.Brace.Param -> {
                return "braceparam"
            }
            is Node.Expr.This -> {
                return "this"
            }
            is Node.Expr.Super -> {
                return "super"
            }
            is Node.Expr.When -> {
                return "when"
            }
            is Node.Expr.Object -> {
                return "object"
            }
            is Node.Expr.Throw -> {
                return "throw "
            }
            is Node.Expr.Return -> {
                return "return ${declareExpr(expr.expr)}"
            }
            is Node.Expr.Continue -> {
                return "continue"
            }
            is Node.Expr.Break -> {
                return "break"
            }
            is Node.Expr.CollLit -> TODO()
            is Node.Expr.Name -> {
                return expr.name
            }
            is Node.Expr.Labeled -> {
                return "${expr.label} ${declareExpr(expr.expr)}"
            }
            is Node.Expr.Annotated -> TODO()
            is Node.Expr.Call -> {
                var text = declareExpr(expr.expr)

                if (expr.args.isNotEmpty()) {
                    text += "("
                    text += expr.args
                        .map { declareValueArg(it) }
                        .joinToString { it }
                    text += ")"
                } else if (expr.lambda == null) {
                    text += "()"
                }

                text += expr.lambda?.let { lambda ->
                    declareExpr(lambda.func)
                } ?: ""

                return text
            }
            is Node.Expr.ArrayAccess -> {
                var text = declareExpr(expr.expr)
                text += "["

                expr.indices.map { declareExpr(it) }.joinToString(separator = ", ") { it }
                text += "]"
                return text
            }
            is Node.Expr.AnonFunc -> TODO()
            is Node.Expr.Property -> {
                return declare(expr.decl)
            }
            null -> ""
        }
    }

    private fun declarePropertyVar(decl: Node.Decl.Property.Var?): String {
        var text = decl?.name ?: ""

        text += decl?.type?.let {
            ": ${declareTypeRef(it.ref)}"
        } ?: ""

        return text
    }

    private fun declareExprBlock(block: Node.Block?): String {
        return block?.let { block ->
            block.stmts
                .map {
                    when (it) {
                        is Node.Stmt.Decl -> declare(it.decl)
                        is Node.Stmt.Expr -> declareExpr(it.expr)
                    }
                }
                .joinToString(separator = "\n${withIdent()}") { it }
        } ?: ""
    }

    private fun declareValueArg(decl: Node.ValueArg): String {
        var text = ""

        text += declareExpr(decl.expr)
        text += decl.name?.let { " $it" } ?: ""
        return text
    }

    private fun declareBodyBlock(body: Node.Decl.Func.Body.Block): String {
        return body.block.stmts.map {
            when (it) {
                is Node.Stmt.Decl -> declare(it.decl)
                is Node.Stmt.Expr -> declareExpr(it.expr)
            }
        }.joinToString(separator = "\n") { withIdent(it) }
    }

    private fun declareProperty(decl: Node.Decl.Property): String {
        var text = decl.vars.map {
            "${declareTypeRef(it?.type?.ref)} ${it?.name}"
        }.joinToString(separator = "") { it }

        text += decl.expr?.let {
            " = ${declareExpr(decl.expr)}"
        } ?: ""

        return text
    }

    private fun declareTypeRef(ref: Node.TypeRef?): String {
        return when (ref) {
            is Node.TypeRef.Paren -> TODO()
            is Node.TypeRef.Func -> TODO()
            is Node.TypeRef.Simple -> {
                return ref.pieces.map {
                    var text = it.name

                    if (it.typeParams.isNotEmpty()) {
                        text += "<"

                        text += it.typeParams
                            .map { paramRef -> declareTypeRef(paramRef?.ref) }
                            .joinToString(separator = ", ") { paramRef -> paramRef }

                        text += ">"
                    }

                    return text
                }.joinToString(separator = "") { it }

            }
            is Node.TypeRef.Nullable -> {
                "nullable ${declareTypeRef(ref.type)}"
            }
            is Node.TypeRef.Dynamic -> TODO()
            null -> ""
        }
    }

    private fun declareStructured(decl: Node.Decl.Structured): String {
        var declareText = ""

        when (decl.form) {
            Form.INTERFACE -> {
                declareText += "protocol ${decl.name}"

                if (decl.parents.isNotEmpty()) {
                    declareText += ": "
                    declareText += decl.parents.map { declareParent(it) }
                        .joinToString(separator = ",") { it }
                }

                declareText += " {\n"
            }
            Form.CLASS -> {
                declareText += "class ${decl.name}"

                if (decl.parents.isNotEmpty()) {
                    declareText += ": "
                    declareText += decl.parents.map { declareParent(it) }
                        .joinToString(separator = ",") { it }
                }

                declareText += " {\n"

            }
            Form.COMPANION_OBJECT -> {

            }
            Form.ENUM_CLASS -> {
                declareText += "enum ${decl.name} "

            }
            Form.OBJECT -> {

            }

        }

        ident++
        declareText += decl.members
            .map { declare(it) }
            .joinToString(separator = "") { withIdent(it) }

        declareText += "}\n"
        ident--

        return declareText
    }

    private fun declareParent(decl: Parent): String {
        return when (decl) {
            is Parent.CallConstructor -> TODO()
            is Parent.Type -> declareTypeRef(decl.type)
        }
    }

    private fun withIdent(str: String = ""): String {
        return "${" ".repeat(ident * 2)}$str"
    }

}