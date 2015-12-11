package com.omixy.jetbrainssaltplugin.lang.lexer.saltstate;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.intellij.psi.tree.IElementType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.omixy.jetbrainssaltplugin.lang.lexer.saltstate.SaltStateTokenTypes.*;

public class SaltStateLexerTest {
    @Test
    public void testSimpleDefTokenization() {
        testTokenization("#", COMMENT);
        testTokenization("# ", COMMENT);
        testTokenization("# Text", COMMENT);
        testTokenization("# Text  ", COMMENT);
        testTokenization("# Text  Text", COMMENT);
    }

    private void testTokenization(String code, IElementType... expectedTokens) {
        SaltStateLexer lexer = new SaltStateLexer();
        lexer.start(code);

        int i = 1;
        for (IElementType expectedToken : expectedTokens) {
            IElementType tokenType = lexer.getTokenType();
            Assert.assertEquals("Wrong match at #" + i,
                    expectedToken, tokenType);
            lexer.advance();
            ++i;
        }

        //check if the lexer has tokens left
        boolean noTokensLeft = lexer.getTokenType() == null;
        if (!noTokensLeft) {
            List<IElementType> tokens = Lists.newLinkedList();
            while (lexer.getTokenType() != null) {
                tokens.add(lexer.getTokenType());
                lexer.advance();
            }

            Assert.assertTrue("Lexer has tokens left: " + Iterables.toString(tokens), noTokensLeft);
        }
    }
}
