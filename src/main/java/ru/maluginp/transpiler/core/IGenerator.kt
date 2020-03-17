package ru.maluginp.transpiler.core

interface IGenerator {
    fun formatPackage(packageName: String): String
    fun formatImport(packageName: String): String
    fun formatEnum(name: String): String
    fun formatIf(expr: String, body: String, elseBody: String?): String
}

interface TrElement

interface TrPackage : TrElement {
    val name: String
}

data class AstTrPackage(override val name: String) : TrPackage

interface TrImport : TrElement {
    val name: String
}

data class AstTrImport(override val name: String) : TrImport

interface TrIf : TrElement {
    val expr: String
    val body: String
    val elseBody: String?
}

data class AstTrIf(
    override val expr: String,
    override val body: String,
    override val elseBody: String? = null
) : TrIf


interface TrFor : TrElement {
    val exprLeft: Collection<TrPropertyVar>
    val exprRight: String
    val body: String
}

data class AstTrFor(
    override val exprLeft: Collection<TrPropertyVar>,
    override val exprRight: String,
    override val body: String
) : TrFor

interface TrFunc: TrElement {
    val name: String?
    val params: Collection<TrFuncParam>
    val returnType: String
    val modifiers: Collection<TrModifier>
    val body: String?
}

data class AstTrFunc(
    override val name: String?,
    override val params: Collection<TrFuncParam>,
    override val returnType: String,
    override val modifiers: Collection<TrModifier>,
    override val body: String?
): TrFunc

interface TrBinaryOp : TrElement {
    val left: String
    val right: String
    val op: String
}

data class AstTrBinaryOp(
    override val left: String,
    override val right: String,
    override val op: String
) : TrBinaryOp


interface TrUnaryOp: TrElement {
    val prefix: Boolean
    val expr: String
    val op: String
}

data class AstTrUnaryOp(
    override val prefix: Boolean,
    override val expr: String,
    override val op: String
) : TrUnaryOp


interface TrWhile: TrElement {
    val expr: String
    val body: String
}

data class AstTrWhile(
    override val expr: String,
    override val body: String
) : TrWhile


interface TrThrow: TrElement {
    val expr: String
}

data class AstTrThrow(
    override val expr: String
): TrThrow

interface Transpiler {
    fun format(element: TrElement): String
}

interface TrReturn: TrElement {
    val expr: String
    val label: String?
}

data class AstTrReturn(
    override val expr: String,
    override val label: String?
): TrReturn


interface TrCall: TrElement {
    val expr: String
    val args: Collection<TrValueArg>
}

data class AstTrCall(
    override val expr: String,
    override val args: Collection<TrValueArg>
): TrCall

interface TrCallLambda: TrElement {
    val expr: String
    val args: Collection<TrValueArg>
    val lambda: String
}

data class AstTrCallLambda(
    override val expr: String,
    override val args: Collection<TrValueArg>,
    override val lambda: String
): TrCallLambda

interface TrInterface: TrElement {
    val name: String
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}

data class AstTrInterface(
    override val name: String,
    override val parents: Collection<TrParent>,
    override val members: Collection<TrMember>
) : TrInterface

interface TrClass: TrElement {
    val name: String
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}

data class AstTrClass(
    override val name: String,
    override val parents: Collection<TrParent>,
    override val members: Collection<TrMember>
): TrClass

interface TrParent: TrElement {
    val expr: String
}

data class AstTrParent(
    override val expr: String
): TrParent

interface TrMember: TrElement {
    val expr: String
}

data class AstTrMember(
    override val expr: String
): TrMember


interface TrObject: TrElement {
    val name: String
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}

data class AstTrObject(
    override val name: String,
    override val parents: Collection<TrParent>,
    override val members: Collection<TrMember>
): TrObject

interface TrCompanionObject: TrElement {
    val name: String
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}

data class AstTrCompanionObject(
    override val name: String,
    override val parents: Collection<TrParent>,
    override val members: Collection<TrMember>
): TrObject

interface TrEnumClass: TrElement {
    val name: String
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}

data class AstTrEnumClass(
    override val name: String,
    override val parents: Collection<TrParent>,
    override val members: Collection<TrMember>
): TrEnumClass

interface TrExprConst: TrElement {
    val value: String
}

data class AstTrExprConst(
    override val value: String
): TrExprConst

interface TrExprTypeOp: TrElement {
    val expr: String
    val op: String
    val type: String
}

data class AstTrExprTypeOp(
    override val expr: String,
    override val op: String,
    override val type: String
): TrExprTypeOp

interface TrExprSuper: TrElement {
    val type: String
    val label: String?
}

data class AstTrExprSuper(
    override val type: String,
    override val label: String?
): TrExprSuper


interface TrExprThis: TrElement {
    val label: String?
}

data class AstTrExprThis(
    override val label: String?
): TrExprThis

interface TrExprContinue: TrElement {
    val label: String?
}

data class AstTrExprContinue(
    override val label: String?
): TrExprContinue

interface TrExprBreak: TrElement{
    val label: String?
}

data class AstTrExprBreak(
    override val label: String?
): TrExprBreak

interface TrExprObject: TrElement {
    val parents: Collection<TrParent>
    val members: Collection<TrMember>
}

data class AstTrExprObject(
    override val parents: Collection<TrParent>,
    override val members: Collection<TrMember>
): TrExprObject

interface TrExprWhen: TrElement {
    val expr: String?
    val entries: Collection<TrExprWhenEntry>
}

data class AstTrExprWhen(
    override val expr: String?,
    override val entries: Collection<TrExprWhenEntry>
): TrExprWhen

interface TrExprWhenEntry: TrElement{
    val conditions: Collection<TrExprWhenEntryCondition>
    val expr: String
}

data class AstTrExprWhenEntry(
    override val conditions: Collection<TrExprWhenEntryCondition>,
    override val expr: String
): TrExprWhenEntry

interface TrExprWhenEntryCondition: TrElement {
    val expr: String
}

interface TrExprWhenEntryConditionIn: TrExprWhenEntryCondition {
    val not: Boolean
}

interface TrExprWhenEntryConditionIs: TrExprWhenEntryCondition {
    val not: Boolean
}

data class AstTrExprWhenEntryCondition(
    override val expr: String
): TrExprWhenEntryCondition

data class AstTrExprWhenEntryConditionIn(
    override val expr: String,
    override val not: Boolean
): TrExprWhenEntryConditionIn

data class AstTrExprWhenEntryConditionIs(
    override val expr: String,
    override val not: Boolean
): TrExprWhenEntryConditionIs

interface TrExprLabeled: TrElement {
    val expr: String
    val label: String?
}

data class AstTrExprLabeled(
    override val expr: String,
    override val label: String?
): TrExprLabeled

interface TrExprName: TrElement {
    val name: String
}

data class AstTrExprName(
    override val name: String
): TrExprName

interface TrExprProperty: TrElement {
    val expr: String
}

data class AstTrExprProperty(
    override val expr: String
): TrExprProperty

interface TrPropertyVar: TrElement {
    val type: String
    val name: String
}

data class AstTrPropertyVar(
    override val type: String,
    override val name: String
): TrPropertyVar

interface TrTypeAlias: TrElement {
    val name: String
    val type: String
    val typeParams: Collection<TrTypeParam>
}

data class AstTrTypeAlias(
    override val name: String,
    override val type: String,
    override val typeParams: Collection<TrTypeParam>
): TrTypeAlias

interface TrTypeParam: TrElement {
    val name: String
    val type: String
}

data class AstTrTypeParam(
    override val name: String,
    override val type: String
): TrTypeParam

interface TrInitBlock: TrElement {
    val expr: TrBlock
}

data class AstTrInitBlock(
    override val expr: TrBlock
): TrInitBlock

interface TrEnum: TrElement {
    val name: String
    val args: List<TrValueArg>
    val members: Collection<TrMember>
}

data class AstTrEnum(
    override val name: String,
    override val args: List<TrValueArg>,
    override val members: Collection<TrMember>
): TrEnum


interface TrValueArg: TrElement {
    val name: String?
    val expr: String
    val asterisk: Boolean
}

data class AstTrValueArg(
    override val name: String?,
    override val expr: String,
    override val asterisk: Boolean
): TrValueArg

interface TrModifier: TrElement {
    val expr: String
}

enum class TrModifierLitKeyword {
    ABSTRACT,
    FINAL,
    OPEN,
    ANNOTATION,

    SEALED,

    DATA,

    OVERRIDE,

    LATEINIT,

    INNER,

    PRIVATE,

    PROTECTED,

    PUBLIC,

    INTERNAL,

    IN,

    OUT,

    NOINLINE,

    CROSSINLINE,

    VARARG,

    REIFIED,

    TAILREC,

    OPERATOR,

    INFIX,

    INLINE,

    EXTERNAL,

    SUSPEND,

    CONST,

    ACTUAL,

    EXPECT;
}

data class AstTrModifier(
    override val expr: String
): TrModifier


interface TrModifierKeyword: TrElement {
    val keyword: TrModifierLitKeyword
}

data class AstTrModifierKeyword(
    override val keyword: TrModifierLitKeyword
): TrModifierKeyword

interface TrFuncParam: TrElement {
    val name: String
    val type: String?
    val default: String?
    val readOnly: Boolean?
}

data class AstTrFuncParam (
    override val name: String,
    override val type: String?,
    override val default: String?,
    override val readOnly: Boolean?
): TrFuncParam

interface TrProperty: TrElement {
    val vars: Collection<TrPropertyVar>
    val readOnly: Boolean
    val delegated: Boolean
    val expr: String?
    val receiveType: String?
    val typeParams: Collection<TrTypeParam>
}

data class AstTrProperty(
    override val vars: Collection<TrPropertyVar>,
    override val readOnly: Boolean,
    override val delegated: Boolean,
    override val expr: String?,
    override val receiveType: String?,
    override val typeParams: Collection<TrTypeParam>
): TrProperty

interface TrBlock: TrElement {
    val statements: Collection<TrStatement>
}

data class AstTrBlock(
    override val statements: Collection<TrStatement>
): TrBlock

interface TrStatement: TrElement {
    val expr: String
}

data class AstTrStatement(
    override val expr: String
): TrStatement

interface TrExprBrace: TrElement {
    val params: Collection<TrExprBraceParam>
    val body: TrBlock?
}

data class AstTrExprBrace(
    override val params: Collection<TrExprBraceParam>,
    override val body: TrBlock?
): TrExprBrace

interface TrExprBraceParam: TrElement {
    val destructType: String?
    val vars: Collection<TrPropertyVar>
}

data class AstTrExprBraceParam(
    override val destructType: String?,
    override val vars: Collection<TrPropertyVar>
): TrExprBraceParam

interface TrAnnotationSet: TrElement {
    val targetName: String?
    val annotations: Collection<TrAnnotation>
}

data class AstTrAnnotationSet(
    override val targetName: String?,
    override val annotations: Collection<TrAnnotation>
): TrAnnotationSet

interface TrAnnotation: TrElement {
    val args: Collection<TrValueArg>
    val names: Collection<String>
    val typeArgs: Collection<String>
}

data class AstTrAnnotation(
    override val args: Collection<TrValueArg>,
    override val names: Collection<String>,
    override val typeArgs: Collection<String>
): TrAnnotation


interface TrTypeRefNullable: TrElement {
    val type: String
}

data class AstTrTypeRefNullable(
    override val type: String
): TrTypeRefNullable


interface TrTypeRefDynamic: TrElement {
}

class AstTrTypeRefDynamic: TrTypeRefDynamic


interface TrTypeRefPiece: TrElement {
    val name: String
    val typeParams: Collection<String>
}
interface TrTypeRef: TrElement {
    val pieces: Collection<TrTypeRefPiece>
}

data class AstTrTypeRef(
    override val pieces: Collection<TrTypeRefPiece>
): TrTypeRef

data class AstTrTypeRefPiece(
    override val name: String,
    override val typeParams: Collection<String>
): TrTypeRefPiece

interface TrTypeRefFunc: TrElement {
    val type: String
    val params: Collection<TrTypeRefFuncParam>
    val receiveType: String
}

data class AstTrTypeRefFunc(
    override val type: String,
    override val params: Collection<TrTypeRefFuncParam>,
    override val receiveType: String
): TrTypeRefFunc

interface TrTypeRefFuncParam: TrElement {
    val name: String?
    val type: String
}

data class AstTrTypeRefFuncParam(
    override val name: String?,
    override val type: String
): TrTypeRefFuncParam

interface TrExprArrayAccess: TrElement {
    val expr: String
    val indices: Collection<String>
}

data class AstTrExprArrayAccess(
    override val expr: String,
    override val indices: Collection<String>
): TrExprArrayAccess

interface TrExprCollLit: TrElement {
    val exprs: List<String>
}

data class AstTrExprCollLit(
    override val exprs: List<String>
): TrExprCollLit

interface TrExprAnnotated: TrElement {
    val expr: String
}

data class AstTrExprAnnotated(
    override val expr: String
): TrExprAnnotated

interface TrExprStringTmpl: TrElement {
    val elements: Collection<String>
}

data class AstTrExprStringTmpl(
    override val elements: Collection<String>
): TrExprStringTmpl

interface TrTry: TrElement {
    val block: TrBlock
    val catches: Collection<TrCatch>
    val finallyBlock: TrBlock?
}

data class AstTrTry(
    override val block: TrBlock,
    override val catches: Collection<TrCatch>,
    override val finallyBlock: TrBlock?
): TrTry


interface TrCatch: TrElement {
    val name: String
    val type: String
    val block: TrBlock
}

data class AstTrCatch(
    override val name: String,
    override val type: String,
    override val block: TrBlock
): TrCatch


interface TrImplementation {
    fun output(): String
}