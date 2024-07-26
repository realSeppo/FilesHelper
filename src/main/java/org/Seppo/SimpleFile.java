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
    public String getExtension(){
        String name = getName();
        int indexOfPoint = name.lastIndexOf(".");
        if(indexOfPoint != -1 && indexOfPoint != 0)
            return name.substring(indexOfPoint);
        else return null;
    }
    public SimpleFile create(String content, Charset charset, boolean rewrite){
        return create(content.getBytes(charset), rewrite);
    }
    public byte[] readBytes() throws IOException {
        return Files.readAllBytes(Path.of(getPath()));
    }
    public String readContent(Charset charset) throws IOException {
        return new String(readBytes(), charset);
    }
}