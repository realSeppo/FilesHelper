package org.Seppo;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleFile extends File {
    public SimpleFile(String path) {
        super(path);
    }
    public SimpleFile create(byte[] content, boolean rewrite){
        if(!(!rewrite && getAbsoluteFile().exists())) {
            try {
                Files.write(Path.of(getPath()), content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }
    public SimpleFile create(String content, boolean rewrite){
        if(!(!rewrite && getAbsoluteFile().exists())) {
            try {
                new FileWriter(this).write(content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }
    public byte[] readBytes() throws IOException {
        return Files.readAllBytes(Path.of(getPath()));
    }
    public String readContent(Charset charset) throws IOException {
        return new String(readBytes(), charset);
    }
}