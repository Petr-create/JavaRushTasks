package com.lessonsjavarush.createtempfile;

import java.io.File;
import java.io.IOException;

public class TempFile {
    public static void main(String[] args) {
        try {
            File tmpFile = File.createTempFile("data", null);
            //папка должна быть, путь к папке на рабочем столе
            File newFile = File.createTempFile("text", ".txt",
                    new File("/Users/petr/Desktop/tempfile"));
            tmpFile.deleteOnExit();
            newFile.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
