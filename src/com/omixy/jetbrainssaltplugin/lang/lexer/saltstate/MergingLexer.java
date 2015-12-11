package com.omixy.jetbrainssaltplugin.lang.lexer.saltstate;

import com.intellij.lexer.Lexer;
import com.intellij.lexer.MergeFunction;
import com.intellij.lexer.MergingLexerAdapterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

class MergingLexer extends MergingLexerAdapterBase {
    private final MergeTuple[] mergeTuples;

    public MergingLexer(final Lexer original, final MergeTuple... mergeTuples) {
        super(original);
        this.mergeTuples = mergeTuples;
    }

    @Override
    public MergeFunction getMergeFunction() {
        return new MergeFunction() {
            @Override
            public IElementType merge(IElementType type, Lexer lexer) {
                for (final MergeTuple currentTuple : mergeTuples) {
                    final TokenSet tokensToMerge = currentTuple.getTokensToMerge();

                    if (tokensToMerge.contains(type)) {
                        IElementType current = lexer.getTokenType();
                        //merge all upcoming tokens into the target token type
                        while (tokensToMerge.contains(current)) {
                            lexer.advance();

                            current = lexer.getTokenType();
                        }

                        return currentTuple.getTargetType();
                    }
                }

                return type;
            }
        };
    }
}
