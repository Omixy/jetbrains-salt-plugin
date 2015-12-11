package com.omixy.jetbrainssaltplugin.file;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import com.omixy.jetbrainssaltplugin.lang.SaltStateLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SaltStateFileType extends LanguageFileType {
    public static final SaltStateFileType SALT_STATE_FILE_TYPE = new SaltStateFileType();
    public static final Language SALT_STATE_LANGUAGE = SALT_STATE_FILE_TYPE.getLanguage();

    public static final String SALT_STATE_EXTENSION = "sls";
    public static final String SALT_STATE_NAME = "Salt State";
    public static final String SALT_STATE_DESCRIPTION = "Salt state file";
    public static final String SALT_STACK_ICON_PATH = "/salt.png";

    protected SaltStateFileType() {
        super(new SaltStateLanguage());
    }

    @NotNull
    @Override
    public String getName() {
        return SALT_STATE_NAME;
    }

    @NotNull
    @Override
    public String getDescription() {
        return SALT_STATE_DESCRIPTION;
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return SALT_STATE_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return IconLoader.getIcon(SALT_STACK_ICON_PATH);
    }
}
