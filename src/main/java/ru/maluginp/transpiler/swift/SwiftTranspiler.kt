package ru.maluginp.transpiler.swift

import ru.maluginp.transpiler.core.*

class SwiftTranspiler : Transpiler {
    override fun format(element: TrElement): String = when (element) {
        is TrPackage -> SwiftTrPackage(element)
        is TrImport -> SwiftTrImport(element)
        is TrIf -> SwiftTrIf(element)
        is TrFor -> SwiftTrFor(element)
        is TrFunc -> SwiftTrFunc(element)
        is TrBinaryOp -> SwiftTrBinaryOp(element)
        is TrUnaryOp -> SwiftTrUnaryOp(element)
        is TrWhile -> SwiftTrWhile(element)
        is TrThrow -> SwiftTrThrow(element)
        is TrReturn -> SwiftTrReturn(element)
        is TrCall -> SwiftTrCall(element)
        is TrCallLambda -> SwiftTrCallLambda(element)
        is TrInterface -> SwiftTrInterface(element)
        is TrClass -> SwiftTrClass(element)
        is TrParent -> SwiftTrParent(element)
        is TrMember -> SwiftTrMember(element)
        is TrObject -> SwiftTrObject(element)
        is TrCompanionObject -> SwiftTrCompanionObject(element)
        is TrEnumClass -> SwiftTrEnumClass(element)
        is TrExprConst -> SwiftTrExprConst(element)
        is TrExprTypeOp -> SwiftTrExprTypeOp(element)
        is TrExprSuper -> SwiftTrExprSuper(element)
        is TrExprThis -> SwiftTrExprThis(element)
        is TrExprContinue -> SwiftTrExprContinue(element)
        is TrExprBreak -> SwiftTrExprBreak(element)
        is TrExprObject -> SwiftTrExprObject(element)
        is TrExprWhen -> SwiftTrExprWhen(element)
        is TrExprWhenEntry -> SwiftTrExprWhenEntry(element)
        is TrExprWhenEntryConditionIn -> SwiftTrExprWhenEntryConditionIn(element)
        is TrExprWhenEntryConditionIs -> SwiftTrExprWhenEntryConditionIs(element)
        is TrExprWhenEntryCondition -> SwiftTrExprWhenEntryCondition(element)
        is TrExprLabeled -> SwiftTrExprLabeled(element)
        is TrExprName -> SwiftTrExprName(element)
        is TrExprProperty -> SwiftTrExprProperty(element)
        is TrPropertyVar -> SwiftTrPropertyVar(element)
        is TrTypeAlias -> SwiftTrTypeAlias(element)
        is TrTypeParam -> SwiftTrTypeParam(element)
        is TrInitBlock -> SwiftTrInitBlock(element)
        is TrEnum -> SwiftTrEnum(element)
        is TrValueArg -> SwiftTrValueArg(element)
        is TrModifier -> SwiftTrModifier(element)
        is TrModifierKeyword -> SwiftTrModifierKeyword(element)
        is TrFuncParam -> SwiftTrFuncParam(element)
        is TrProperty -> SwiftTrProperty(element)
        is TrBlock -> SwiftTrBlock(element)
        is TrStatement -> SwiftTrStatement(element)
        is TrExprBrace -> SwiftTrExprBrace(element)
        is TrExprBraceParam -> SwiftTrExprBraceParam(element)
        is TrAnnotationSet -> SwiftTrAnnotationSet(element)
        is TrAnnotation -> SwiftTrAnnotation(element)
        is TrTypeRefNullable -> SwiftTrTypeRefNullable(element)
        is TrTypeRefDynamic -> SwiftTrTypeRefDynamic(element)
        is TrTypeRefPiece -> SwiftTrTypeRefPiece(element)
        is TrTypeRef -> SwiftTrTypeRef(element)
        is TrTypeRefFunc -> SwiftTrTypeRefFunc(element)
        is TrTypeRefFuncParam -> SwiftTrTypeRefFuncParam(element)
        is TrExprArrayAccess -> SwiftTrExprArrayAccess(element)
        is TrExprCollLit -> SwiftTrExprCollLit(element)
        is TrExprAnnotated -> SwiftTrExprAnnotated(element)
        is TrExprStringTmpl -> SwiftTrExprStringTmpl(element)
        is TrTry -> SwiftTrTry(element)
        is TrCatch -> SwiftTrCatch(element)
        else -> SwiftTrEmpty()
    }.let(TrImplementation::output)
}