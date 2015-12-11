package com.omixy.jetbrainssaltplugin.lang.lexer.saltstate;

import com.intellij.lexer.*;
import com.intellij.psi.tree.TokenSet;

public class SaltStateLexer extends MergingLexer implements SaltStateTokenTypes {
    public SaltStateLexer() {
        super(new FlexAdapter(new _SaltStateLexer(null)));
    }
}
