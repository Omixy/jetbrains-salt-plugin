package com.omixy.jetbrainssaltplugin.lang.lexer.saltstate;

import com.intellij.psi.tree.IElementType;

public interface SaltStateTokenTypes {
    IElementType COMMENT = new SaltStateElementType("Comment");
    IElementType WHITESPACE = new SaltStateElementType("Whitespace");
    IElementType INPUT_CHARACTER = new SaltStateElementType("InputCharacter");
}
