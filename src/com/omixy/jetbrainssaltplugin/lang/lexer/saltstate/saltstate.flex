package com.omixy.jetbrainssaltplugin.lang.lexer.saltstate;
import com.intellij.psi.tree.IElementType;

%%

%class _SaltStateLexerBase
%implements SaltStateLexerDef
%abstract
%public
%char

%function advance
%type IElementType

%{
    long yychar = 0;
%}

/***** Custom user code *****/
Whitespace = " "
InputCharacter = [a-zA-Z]
Comment = "#" ( {InputCharacter} | {Whitespace} )*

%%
/***************************** INITIAL STAATE ************************************/
<YYINITIAL> {
  {Comment}                     { return COMMENT; }
}