package com.omixy.jetbrainssaltplugin.lang.lexer.saltstate;

import com.intellij.psi.tree.IElementType;
import com.omixy.jetbrainssaltplugin.file.SaltStateFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SaltStateElementType extends IElementType {
    public SaltStateElementType(@NotNull @NonNls String debugName) {
        super(debugName, SaltStateFileType.SALT_STATE_LANGUAGE);
    }


    @Override
    public String toString() {
        return "[SaltState] " + super.toString();
    }
}
