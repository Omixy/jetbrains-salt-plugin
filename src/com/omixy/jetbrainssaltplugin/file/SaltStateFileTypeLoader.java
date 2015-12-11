package com.omixy.jetbrainssaltplugin.file;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class SaltStateFileTypeLoader extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(SaltStateFileType.SALT_STATE_FILE_TYPE, SaltStateFileType.SALT_STATE_EXTENSION);
    }
}
