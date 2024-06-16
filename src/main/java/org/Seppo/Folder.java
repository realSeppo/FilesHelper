package org.Seppo;

import java.io.File;

public class Folder extends File{
    public Folder(String path){
        super(path);
        
        if(!exists()){
            mkdir();
        }
    }
}
