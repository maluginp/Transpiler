package ru.maluginp.transpiler.convertors

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
    val exprLeft: Iterable<TrPropertyVar>
    val exprRight: String
    val body: String
}

data class AstTrFor(
    override val exprLeft: Iterable<TrPropertyVar>,
    override val exprRight: String,
    override val body: String
) : TrFor

interface TrFunc: TrElement {
    val name: String?
    val params: Iterable<TrFuncParam>
    val returnType: String
    val modifiers: Iterable<TrModifier>
    val body: String?
}

data class AstTrFunc(
    override val name: String?,
    override val params: Iterable<TrFuncParam>,
    override val returnType: String,
    override val modifiers: Iterable<TrModifier>,
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
    val args: Iterable<TrValueArg>
}

data class AstTrCall(
    override val expr: String,
    override val args: Iterable<TrValueArg>
): TrCall

interface TrCallLambda: TrElement {
    val expr: String
    val args: Iterable<TrValueArg>
    val lambda: String
}

data class AstTrCallLambda(
    override val expr: String,
    override val args: Iterable<TrValueArg>,
    override val lambda: String
): TrCallLambda

interface TrInterface: TrElement {
    val name: String
    val parents: Iterable<TrStructureParent>
    val members: Iterable<TrStructureMember>
}

data class AstTrInterface(
    override val name: String,
    override val parents: Iterable<TrStructureParent>,
    override val members: Iterable<TrStructureMember>
) : TrInterface

interface TrClass: TrElement {
    val name: String
    val parents: Iterable<TrStructureParent>
    val members: Iterable<TrStructureMember>
}

data class AstTrClass(
    override val name: String,
    override val parents: Iterable<TrStructureParent>,
    override val members: Iterable<TrStructureMember>
): TrClass

interface TrStructureParent: TrElement {
    val expr: String
}

data class AstTrStructureParent(
    override val expr: String
): TrStructureParent

interface TrStructureMember: TrElement {
    val expr: String
}

data class AstTrStructureMember(
    override val expr: String
): TrStructureMember


interface TrObject: TrElement {
    val name: String
    val parents: Iterable<TrStructureParent>
    val members: Iterable<TrStructureMember>
}

data class AstTrObject(
    override val name: String,
    override val parents: Iterable<TrStructureParent>,
    override val members: Iterable<TrStructureMember>
): TrObject

interface TrCompanionObject: TrElement {
    val name: String
    val parents: Iterable<TrStructureParent>
    val members: Iterable<TrStructureMember>
}

data class AstTrCompanionObject(
    override val name: String,
    override val parents: Iterable<TrStructureParent>,
    override val members: Iterable<TrStructureMember>
): TrObject

interface TrEnumClass: TrElement {
    val name: String
    val parents: Iterable<TrStructureParent>
    val members: Iterable<TrStructureMember>
}

data class AstTrEnumClass(
    override val name: String,
    override val parents: Iterable<TrStructureParent>,
    override val members: Iterable<TrStructureMember>
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
    val parents: Iterable<TrStructureParent>
    val members: Iterable<TrStructureMember>
}

data class AstTrExprObject(
    override val parents: Iterable<TrStructureParent>,
    override val members: Iterable<TrStructureMember>
): TrExprObject

interface TrExprWhen: TrElement {
    val expr: String?
    val entries: Iterable<TrExprWhenEntry>
}

data class AstTrExprWhen(
    override val expr: String?,
    override val entries: Iterable<TrExprWhenEntry>
): TrExprWhen

interface TrExprWhenEntry: TrElement{
    val conditions: Iterable<TrExprWhenEntryCondition>
    val expr: String
}

data class AstTrExprWhenEntry(
    override val conditions: Iterable<TrExprWhenEntryCondition>,
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
    val typeParams: Iterable<TrTypeParam>
}

data class AstTrTypeAlias(
    override val name: String,
    override val type: String,
    override val typeParams: Iterable<TrTypeParam>
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
    val members: Iterable<TrStructureMember>
}

data class AstTrEnum(
    override val name: String,
    override val args: List<TrValueArg>,
    override val members: Iterable<TrStructureMember>
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

data class AstTrModifier(
    override val expr: String
): TrModifier

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
    val vars: Iterable<TrPropertyVar>
    val readOnly: Boolean
    val delegated: Boolean
    val expr: String?
    val receiveType: String?
    val typeParams: Iterable<TrTypeParam>
}

data class AstTrProperty(
    override val vars: Iterable<TrPropertyVar>,
    override val readOnly: Boolean,
    override val delegated: Boolean,
    override val expr: String?,
    override val receiveType: String?,
    override val typeParams: Iterable<TrTypeParam>
): TrProperty

interface TrBlock: TrElement {
    val statements: Iterable<TrStatement>
}

data class AstTrBlock(
    override val statements: Iterable<TrStatement>
): TrBlock

interface TrStatement: TrElement {
    val expr: String
}

data class AstTrStatement(
    override val expr: String
): TrStatement

interface TrExprBrace: TrElement {
    val params: Iterable<TrExprBraceParam>
    val body: TrBlock?
}

data class AstTrExprBrace(
    override val params: Iterable<TrExprBraceParam>,
    override val body: TrBlock?
): TrExprBrace

interface TrExprBraceParam: TrElement {
    val destructType: String?
    val vars: Iterable<TrPropertyVar>
}

data class AstTrExprBraceParam(
    override val destructType: String?,
    override val vars: Iterable<TrPropertyVar>
): TrExprBraceParam