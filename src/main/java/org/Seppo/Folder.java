package org.Seppo;

import java.io.File;

public class Folder extends File{
    public Folder(String path){
        super(path);

        if(!exists()){
            mkdir();
        }
    }

    public SimpleFile[] listSimpleFiles(){
        File[] files = listFiles();
        SimpleFile[] simpleFiles = new SimpleFile[files.length];
        for(int i = 0; i < files.length; i++) {
            simpleFiles[i] = new SimpleFile(files[i].getPath());
        }
        return simpleFiles;
    }
}
