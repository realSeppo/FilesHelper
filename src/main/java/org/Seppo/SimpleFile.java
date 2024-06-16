package org.Seppo;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleFile extends File {
    public SimpleFile(String path) {
        super(path);
    }
    public SimpleFile(String path, byte[] content, boolean rewrite) {
        super(path);
        if(!rewrite && exists()) return;
        System.out.println(!rewrite + " " + exists());
        try {
            createNewFile();
            Files.write(Path.of(path), content);
        } catch (IOException e) {throw new RuntimeException(e);}
    }
    public SimpleFile(String path, String content, boolean rewrite) {
        super(path);
        if(!rewrite && exists()) return;
        try {
            createNewFile();
            new FileWriter(this).write(content);
        } catch (IOException e) {throw new RuntimeException(e);}
    }
    public byte[] readBytes() throws IOException {
        return Files.readAllBytes(Path.of(getPath()));
    }
    public String readContent(Charset charset) throws IOException {
        return new String(readBytes(), charset);
    }
}