package ru.maluginp.transpiler.convertors

import kastree.ast.Node
import kastree.ast.Node.Decl.Structured.*
import kastree.ast.Node.Modifier.Keyword.*

class ASTConvertor(val transpiler: Transpiler) {
    var ident = 0

    fun run(file: Node.File): String {
        var output = ""

        output += file.pkg?.let { pkg ->
            val packageName = pkg.names
                .map { it }
                .joinToString(separator = ".") { it }

            wrapIfNotEmpty(transpiler.format(AstTrPackage(packageName)))
        } ?: ""

        output += file.imports.map { import ->
            val packageName: String = import.names
                .map { it }
                .joinToString(separator = ".") { it }

            wrapIfNotEmpty(transpiler.format(AstTrImport(packageName)))
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

//        declareText += generator.formatEnum(decl.name)

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


        declareText += transpiler.format(AstTrFunc(
            decl.name ?: "",
            decl.params.map {
                "${declareTypeRef(it.type?.ref)} ${it.name}"
            }.joinToString(separator = "") { it },
            declareTypeRef(decl.type?.ref),
            decl.body?.let {declareBody(it)}
        ))

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

                transpiler.format(AstTrIf(
                    declareExpr(expr.expr),
                    declareExpr(expr.body),
                    expr.elseBody?.let { declareExpr(expr.elseBody) }
                ))
            }
            is Node.Expr.Try -> TODO()
            is Node.Expr.For -> {
                val vars = expr.vars.map {
                    declarePropertyVar(it)
                }.joinToString { it }
//                var text = "for ($vars in $inExpr)"
//
//                text += declareExpr(expr.body)
                transpiler.format(AstTrFor(vars, declareExpr(expr.inExpr), declareExpr(expr.body)))
            }
            is Node.Expr.While -> {
//                var text = "while("
//                text += declareExpr(expr.expr)
//                text += ")"
//
//                text += declareExpr(expr.body)

                return transpiler.format(AstTrWhile(
                    declareExpr(expr.expr),
                    declareExpr(expr.body)
                ))
            }
            is Node.Expr.BinaryOp -> {
                var oper = expr.oper

                var operator: String = when (oper) {
                    is Node.Expr.BinaryOp.Oper.Infix -> oper.str
                    is Node.Expr.BinaryOp.Oper.Token -> oper.token.str
                }


                return transpiler.format(AstTrBinaryOp(
                    declareExpr(expr.lhs),
                    declareExpr(expr.rhs),
                    operator
                ))
//                return "${declareExpr(expr.lhs)}${operator}${declareExpr(expr.rhs)}"
            }
            is Node.Expr.UnaryOp -> {
                return transpiler.format(AstTrUnaryOp(
                    expr.prefix,
                    declareExpr(expr.expr),
                    expr.oper.token.str
                ))

//                if (expr.prefix) {
//                    return "$operator${declareExpr(expr.expr)}"
//                } else {
//                    return "${declareExpr(expr.expr)}$operator"
//                }
            }
            is Node.Expr.TypeOp -> {
                return transpiler.format(AstTrExprTypeOp(
                    declareExpr(expr.lhs),
                    expr.oper.token.str,
                    declareTypeRef(expr.rhs.ref)
                ))

            }
            is Node.Expr.DoubleColonRef.Callable -> {
                return "DoubleColonRef.Callable ${expr.name}"
            }
            is Node.Expr.DoubleColonRef.Class -> {
                return "DoubleColonRef.class"
            }
            is Node.Expr.Paren -> {
                return declareExpr(expr.expr)
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
//                when(expr.form) {
//                    Node.Expr.Const.Form.BOOLEAN -> TODO()
//                    Node.Expr.Const.Form.CHAR -> TODO()
//                    Node.Expr.Const.Form.INT -> TODO()
//                    Node.Expr.Const.Form.FLOAT -> TODO()
//                    Node.Expr.Const.Form.NULL -> TODO()
//                }

                return transpiler.format(AstTrExprConst(expr.value))
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
                return transpiler.format(AstTrExprThis(expr.label))
            }
            is Node.Expr.Super -> {
                return transpiler.format(AstTrExprSuper(
                    declareTypeRef(expr.typeArg?.ref),
                    expr.label
                ))
            }
            is Node.Expr.When -> {
                return transpiler.format(AstTrExprWhen(
                    declareExpr(expr.expr),
                    expr.entries.map { entry -> AstTrExprWhenEntry(
                        entry.conds.map { declareWhenCond(it) },
                        declareExpr(entry.body)
                    )}
                ))
            }
            is Node.Expr.Object -> {
                return transpiler.format(AstTrExprObject(
                    expr.parents.map { AstTrStructureParent(declareParent(it)) },
                    expr.members.map { AstTrStructureMember(declare(it)) }
                ))
            }
            is Node.Expr.Throw -> {
                return transpiler.format(AstTrThrow(declareExpr(expr.expr)))
            }
            is Node.Expr.Return -> {
                return transpiler.format(AstTrReturn(
                    declareExpr(expr.expr),
                    expr.label
                ))
            }
            is Node.Expr.Continue -> {
                return transpiler.format(AstTrExprContinue(expr.label))
            }
            is Node.Expr.Break -> {
                return transpiler.format(AstTrExprBreak(expr.label))
            }
            is Node.Expr.CollLit -> TODO()
            is Node.Expr.Name -> {
                return transpiler.format(AstTrExprName(expr.name))
            }
            is Node.Expr.Labeled -> {
                return transpiler.format(AstTrExprLabeled(
                    declareExpr(expr.expr),
                    expr.label
                ))
            }
            is Node.Expr.Annotated -> TODO()
            is Node.Expr.Call -> {
                return if (expr.lambda == null) {
                    AstTrCall(
                        declareExpr(expr.expr),
                        expr.args
                            .map { declareValueArg(it) }
                            .joinToString { it }
                    )
                } else {
                    AstTrCallLambda(
                        declareExpr(expr.expr),
                        expr.args
                            .map { declareValueArg(it) }
                            .joinToString { it },
                        declareExpr(expr.lambda?.func)
                    )
                }.let(transpiler::format)
            }
            is Node.Expr.ArrayAccess -> {
                var text = declareExpr(expr.expr)
                text += "["

                expr.indices.map { declareExpr(it) }.joinToString(separator = ", ") { it }
                text += "]"
                return text
            }
            is Node.Expr.AnonFunc -> {
                return ""
            }
            is Node.Expr.Property -> {
                return transpiler.format(AstTrExprProperty(declare(expr.decl)))
            }
            null -> ""
        }
    }

    private fun declareWhenCond(cond: Node.Expr.When.Cond): TrExprWhenEntryCondition {
        return when(cond) {
            is Node.Expr.When.Cond.Expr -> AstTrExprWhenEntryCondition(declareExpr(cond.expr))
            is Node.Expr.When.Cond.In -> AstTrExprWhenEntryConditionIn(declareExpr(cond.expr), cond.not)
            is Node.Expr.When.Cond.Is -> AstTrExprWhenEntryConditionIs(declareTypeRef(cond.type.ref), cond.not)
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
        return when (decl.form) {
            Form.INTERFACE -> {
                AstTrInterface(
                    decl.name,
                    decl.parents.map { AstTrStructureParent(declareParent(it)) },
                    decl.members.map { AstTrStructureMember(declare(it))  }
                )
            }
            Form.CLASS -> {
                AstTrClass(
                    decl.name,
                    decl.parents.map { AstTrStructureParent(declareParent(it)) },
                    decl.members.map { AstTrStructureMember(declare(it))  }
                )
            }
            Form.COMPANION_OBJECT -> {
                AstTrCompanionObject(
                    decl.name,
                    decl.parents.map { AstTrStructureParent(declareParent(it)) },
                    decl.members.map { AstTrStructureMember(declare(it))  }
                )
            }
            Form.ENUM_CLASS -> {
                AstTrEnumClass(
                    decl.name,
                    decl.parents.map { AstTrStructureParent(declareParent(it)) },
                    decl.members.map { AstTrStructureMember(declare(it))  }
                )

            }
            Form.OBJECT -> {
                AstTrObject(
                    decl.name,
                    decl.parents.map { AstTrStructureParent(declareParent(it)) },
                    decl.members.map { AstTrStructureMember(declare(it))  }
                )
            }
        }.let(transpiler::format)
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