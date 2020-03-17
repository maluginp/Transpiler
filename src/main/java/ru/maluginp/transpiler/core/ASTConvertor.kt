package ru.maluginp.transpiler.core

import kastree.ast.Node
import kastree.ast.Node.Decl.Structured.*
import kastree.ast.Node.Modifier.Keyword.*

class ASTConvertor(val transpiler: Transpiler) {

    fun run(file: Node.File): String {
        var output = ""

        output += file.pkg?.let { pkg ->
            val packageName = pkg.names
                .map { it }
                .joinToString(separator = ".") { it }

            transpiler.format(AstTrPackage(packageName))
        } ?: ""

        output += file.imports.map { import ->
            val packageName: String = import.names
                .map { it }
                .joinToString(separator = ".") { it }

            transpiler.format(AstTrImport(packageName))
        }.joinToString(separator = "") { it }

//        output += "\n"

        output += file.decls.map {
            declare(it)
        }.joinToString(separator = "") { it }

        return output
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
        return transpiler.format(AstTrTypeAlias(
            decl.name,
            declareTypeRef(decl.type.ref),
            decl.typeParams.map { AstTrTypeParam(it.name, declareTypeRef(it.type)) }
        ))
    }

    private fun declareInit(decl: Node.Decl.Init): String {
        return transpiler.format(
            AstTrInitBlock(
                declareExprBlock(decl.block)!!
            )
        )
    }

    private fun declareEnum(decl: Node.Decl.EnumEntry): String {
        return transpiler.format(AstTrEnum(
            decl.name,
            decl.args.map { declareValueArg(it) },
            decl.members.map { AstTrMember(declare(it)) }
        ))
    }

    private fun declareModifier(decl: Node.Modifier): TrModifier {
        return when (decl) {
            is Node.Modifier.AnnotationSet -> {
                AstTrModifier(transpiler.format(
                    AstTrAnnotationSet(
                        decl.target?.name,
                        decl.anns.map { ann ->
                            AstTrAnnotation(
                                ann.args.map { declareValueArg(it) },
                                ann.names,
                                ann.typeArgs.map { declareTypeRef(it.ref) }
                            )
                        }
                    )
                ))
            }
            is Node.Modifier.Lit -> when (decl.keyword) {
                ABSTRACT -> TrModifierLitKeyword.ABSTRACT
                FINAL -> TrModifierLitKeyword.FINAL
                OPEN -> TrModifierLitKeyword.OPEN
                ANNOTATION -> TrModifierLitKeyword.ANNOTATION
                SEALED -> TrModifierLitKeyword.SEALED
                DATA -> TrModifierLitKeyword.DATA
                OVERRIDE -> TrModifierLitKeyword.OVERRIDE
                LATEINIT -> TrModifierLitKeyword.LATEINIT
                INNER -> TrModifierLitKeyword.INNER
                PRIVATE -> TrModifierLitKeyword.PRIVATE
                PROTECTED -> TrModifierLitKeyword.PROTECTED
                PUBLIC -> TrModifierLitKeyword.PUBLIC
                INTERNAL -> TrModifierLitKeyword.INTERNAL
                IN -> TrModifierLitKeyword.IN
                OUT -> TrModifierLitKeyword.OUT
                NOINLINE -> TrModifierLitKeyword.NOINLINE
                CROSSINLINE -> TrModifierLitKeyword.CROSSINLINE
                VARARG -> TrModifierLitKeyword.VARARG
                REIFIED -> TrModifierLitKeyword.REIFIED
                TAILREC -> TrModifierLitKeyword.TAILREC
                OPERATOR -> TrModifierLitKeyword.OPERATOR
                INFIX -> TrModifierLitKeyword.INFIX
                INLINE -> TrModifierLitKeyword.INLINE
                EXTERNAL -> TrModifierLitKeyword.EXTERNAL
                SUSPEND -> TrModifierLitKeyword.SUSPEND
                CONST -> TrModifierLitKeyword.CONST
                ACTUAL -> TrModifierLitKeyword.ACTUAL
                EXPECT -> TrModifierLitKeyword.EXPECT
            }.let(::AstTrModifierKeyword).let { AstTrModifier(transpiler.format(it)) }
        }
    }

    private fun declareFunc(decl: Node.Decl.Func): String {
        return transpiler.format(AstTrFunc(
            decl.name,
            decl.params.map { declareFuncParam(it) },
            declareTypeRef(decl.type?.ref),
            decl.mods.map { declareModifier(it) },
            decl.body?.let { declareBody(it) }
        ))

    }

    private fun declareFuncParam(param: Node.Decl.Func.Param): TrFuncParam {
        return AstTrFuncParam(
            param.name,
            declareTypeRef(param.type?.ref),
            declareExpr(param.default),
            param.readOnly
        )
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
            is Node.Expr.If -> transpiler.format(AstTrIf(
                declareExpr(expr.expr),
                declareExpr(expr.body),
                expr.elseBody?.let { declareExpr(expr.elseBody) }
            ))
            is Node.Expr.Try -> {
                transpiler.format(
                    AstTrTry(
                        declareExprBlock(expr.block)!!,
                        expr.catches.map {
                            AstTrCatch(
                                it.varName,
                                declareTypeRef(it.varType),
                                declareExprBlock(it.block)!!
                            )
                        },
                        declareExprBlock(expr.finallyBlock)
                    )
                )
            }
            is Node.Expr.For -> {
                val vars = expr.vars.filterNotNull()
                    .map {
                        AstTrPropertyVar(
                            declareTypeRef(it.type?.ref),
                            it.name
                        )
                    }
                transpiler.format(AstTrFor(vars, declareExpr(expr.inExpr), declareExpr(expr.body)))
            }
            is Node.Expr.While -> transpiler.format(
                AstTrWhile(
                    declareExpr(expr.expr),
                    declareExpr(expr.body)
                )
            )

            is Node.Expr.BinaryOp -> {
                val oper = expr.oper

                val operator: String = when (oper) {
                    is Node.Expr.BinaryOp.Oper.Infix -> oper.str
                    is Node.Expr.BinaryOp.Oper.Token -> oper.token.str
                }


                return transpiler.format(
                    AstTrBinaryOp(
                        declareExpr(expr.lhs),
                        declareExpr(expr.rhs),
                        operator
                    )
                )
            }
            is Node.Expr.UnaryOp -> transpiler.format(
                AstTrUnaryOp(
                    expr.prefix,
                    declareExpr(expr.expr),
                    expr.oper.token.str
                )
            )
            is Node.Expr.TypeOp -> {
                return transpiler.format(
                    AstTrExprTypeOp(
                        declareExpr(expr.lhs),
                        expr.oper.token.str,
                        declareTypeRef(expr.rhs.ref)
                    )
                )

            }
            is Node.Expr.DoubleColonRef.Callable -> TODO()
            is Node.Expr.DoubleColonRef.Class -> TODO()
            is Node.Expr.Paren -> declareExpr(expr.expr)
            is Node.Expr.StringTmpl -> transpiler.format(AstTrExprStringTmpl(
                expr.elems.map {
                    when (it) {
                        is Node.Expr.StringTmpl.Elem.Regular -> it.str
                        is Node.Expr.StringTmpl.Elem.ShortTmpl -> it.str
                        is Node.Expr.StringTmpl.Elem.UnicodeEsc -> it.digits
                        is Node.Expr.StringTmpl.Elem.RegularEsc -> "${it.char}"
                        is Node.Expr.StringTmpl.Elem.LongTmpl -> declareExpr(it.expr)
                    }
                }
            ))
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
                return transpiler.format(
                    AstTrExprBrace(
                        expr.params.map { param ->
                            AstTrExprBraceParam(
                                declareTypeRef(param.destructType?.ref),
                                param.vars.filterNotNull().map {
                                    AstTrPropertyVar(
                                        declareTypeRef(it.type?.ref),
                                        it.name
                                    )
                                }
                            )
                        },
                        declareExprBlock(expr.block)
                    )
                )
            }
            is Node.Expr.This -> {
                return transpiler.format(AstTrExprThis(expr.label))
            }
            is Node.Expr.Super -> {
                return transpiler.format(
                    AstTrExprSuper(
                        declareTypeRef(expr.typeArg?.ref),
                        expr.label
                    )
                )
            }
            is Node.Expr.When -> {
                return transpiler.format(AstTrExprWhen(
                    declareExpr(expr.expr),
                    expr.entries.map { entry ->
                        AstTrExprWhenEntry(
                            entry.conds.map { declareWhenCond(it) },
                            declareExpr(entry.body)
                        )
                    }
                ))
            }
            is Node.Expr.Object -> {
                return transpiler.format(AstTrExprObject(
                    expr.parents.map { AstTrParent(declareParent(it)) },
                    expr.members.map { AstTrMember(declare(it)) }
                ))
            }
            is Node.Expr.Throw -> {
                return transpiler.format(AstTrThrow(declareExpr(expr.expr)))
            }
            is Node.Expr.Return -> {
                return transpiler.format(
                    AstTrReturn(
                        declareExpr(expr.expr),
                        expr.label
                    )
                )
            }
            is Node.Expr.Continue -> transpiler.format(AstTrExprContinue(expr.label))
            is Node.Expr.Break -> transpiler.format(AstTrExprBreak(expr.label))
            is Node.Expr.CollLit -> transpiler.format(AstTrExprCollLit(expr.exprs.map(this::declareExpr)))
            is Node.Expr.Name -> transpiler.format(AstTrExprName(expr.name))
            is Node.Expr.Labeled -> {
                return transpiler.format(
                    AstTrExprLabeled(
                        declareExpr(expr.expr),
                        expr.label
                    )
                )
            }
            is Node.Expr.Annotated -> transpiler.format(AstTrExprAnnotated(declareExpr(expr)))
            is Node.Expr.Call -> {
                return if (expr.lambda == null) {
                    AstTrCall(
                        declareExpr(expr.expr),
                        expr.args.map { declareValueArg(it) }
                    )
                } else {
                    AstTrCallLambda(
                        declareExpr(expr.expr),
                        expr.args.map { declareValueArg(it) },
                        declareExpr(expr.lambda?.func)
                    )
                }.let(transpiler::format)
            }
            is Node.Expr.ArrayAccess -> {
                transpiler.format(AstTrExprArrayAccess(
                    declareExpr(expr.expr),
                    expr.indices.map { declareExpr(it) }
                ))
            }
            is Node.Expr.AnonFunc -> declareFunc(expr.func)
            is Node.Expr.Property -> transpiler.format(AstTrExprProperty(declare(expr.decl)))
            else -> ""
        }
    }

    private fun declareWhenCond(cond: Node.Expr.When.Cond): TrExprWhenEntryCondition {
        return when (cond) {
            is Node.Expr.When.Cond.Expr -> AstTrExprWhenEntryCondition(declareExpr(cond.expr))
            is Node.Expr.When.Cond.In -> AstTrExprWhenEntryConditionIn(declareExpr(cond.expr), cond.not)
            is Node.Expr.When.Cond.Is -> AstTrExprWhenEntryConditionIs(declareTypeRef(cond.type.ref), cond.not)
        }
    }

    private fun declareExprBlock(exprBlock: Node.Block?): TrBlock? {
        return exprBlock?.let { block ->
            AstTrBlock(
                block.stmts.map {
                    when (it) {
                        is Node.Stmt.Decl -> declare(it.decl)
                        is Node.Stmt.Expr -> declareExpr(it.expr)
                    }.let(::AstTrStatement)
                }
            )
        }
    }

    private fun declareValueArg(decl: Node.ValueArg): TrValueArg {
        return AstTrValueArg(
            decl.name,
            declareExpr(decl.expr),
            decl.asterisk
        )
    }

    private fun declareBodyBlock(body: Node.Decl.Func.Body.Block): String {
        return transpiler.format(AstTrBlock(
            body.block.stmts.map {
                when (it) {
                    is Node.Stmt.Decl -> declare(it.decl)
                    is Node.Stmt.Expr -> declareExpr(it.expr)
                }.let { decl -> AstTrStatement(decl) }
            }
        ))
    }

    private fun declareProperty(decl: Node.Decl.Property): String {
        // typeConstraints, accessors, mods

        return transpiler.format(AstTrProperty(
            decl.vars.filterNotNull().map { AstTrPropertyVar(declareTypeRef(it.type?.ref), it.name) },
            decl.readOnly,
            decl.delegated,
            declareExpr(decl.expr),
            declareTypeRef(decl.receiverType?.ref),
            decl.typeParams.map { AstTrTypeParam(it.name, declareTypeRef(it.type)) }
        ))
    }

    private fun declareTypeRef(ref: Node.TypeRef?): String {
        return when (ref) {
            is Node.TypeRef.Paren -> {
                // TODO: Parent
                declareTypeRef(ref.type)
            }
            is Node.TypeRef.Func -> {
                transpiler.format(
                    AstTrTypeRefFunc(
                        declareTypeRef(ref.type.ref),
                        ref.params.map { AstTrTypeRefFuncParam(it.name, declareTypeRef(it.type.ref)) },
                        declareTypeRef(ref.receiverType?.ref)
                    )
                )
            }
            is Node.TypeRef.Simple -> {
                transpiler.format(
                    AstTrTypeRef(
                        ref.pieces.map { piece ->
                            AstTrTypeRefPiece(
                                piece.name,
                                piece.typeParams.filterNotNull().map { declareTypeRef(it.ref) }
                            )
                        })
                )
            }
            is Node.TypeRef.Nullable -> {
                transpiler.format(AstTrTypeRefNullable(declareTypeRef(ref.type)))
            }
            is Node.TypeRef.Dynamic -> {
                transpiler.format(AstTrTypeRefDynamic())
            }
            null -> ""
        }
    }

    private fun declareStructured(decl: Node.Decl.Structured): String {
        return when (decl.form) {
            Form.INTERFACE -> {
                AstTrInterface(
                    decl.name,
                    decl.parents.map { AstTrParent(declareParent(it)) },
                    decl.members.map { AstTrMember(declare(it)) }
                )
            }
            Form.CLASS -> {
                AstTrClass(
                    decl.name,
                    decl.parents.map { AstTrParent(declareParent(it)) },
                    decl.members.map { AstTrMember(declare(it)) }
                )
            }
            Form.COMPANION_OBJECT -> {
                AstTrCompanionObject(
                    decl.name,
                    decl.parents.map { AstTrParent(declareParent(it)) },
                    decl.members.map { AstTrMember(declare(it)) }
                )
            }
            Form.ENUM_CLASS -> {
                AstTrEnumClass(
                    decl.name,
                    decl.parents.map { AstTrParent(declareParent(it)) },
                    decl.members.map { AstTrMember(declare(it)) }
                )

            }
            Form.OBJECT -> {
                AstTrObject(
                    decl.name,
                    decl.parents.map { AstTrParent(declareParent(it)) },
                    decl.members.map { AstTrMember(declare(it)) }
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
}