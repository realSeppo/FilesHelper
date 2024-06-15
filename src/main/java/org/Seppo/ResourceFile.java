package org.Seppo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class ResourceFile {
    private final String path;

    public ResourceFile(String path) {
        this.path = path;
    }
    public String getPath(){
        return path;
    }
    public String getName(){
        return path.substring(path.lastIndexOf("/"));
    }
    public String getContent(Charset charset) throws IOException {
        return new String(getBytes(), charset);
    }
    public InputStream getStream() throws FileNotFoundException {
        InputStream inputStream = ResourceFile.class.getResourceAsStream("/" + path);
        if (inputStream == null) {
            throw new FileNotFoundException("There is no resource on the " + path + " path");
        }
        return inputStream;
    }
    public byte[] getBytes() throws IOException {
        return getStream().readAllBytes();
    }
}
