package com.javarush.task.task19.task1902;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Адаптер
*/

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public static void main(String[] args) throws IOException {
        AdapterFileOutputStream adapterFileOutputStream = new AdapterFileOutputStream(new FileOutputStream("file"));
        adapterFileOutputStream.writeString("");
        adapterFileOutputStream.flush();
        adapterFileOutputStream.close();
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}

