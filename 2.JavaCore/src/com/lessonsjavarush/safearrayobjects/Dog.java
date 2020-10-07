package com.lessonsjavarush.safearrayobjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Dog {
    public String name;
    public int age;

    public void save(PrintWriter writer){
        writer.println(name);
        writer.println(age);
        writer.flush();

    }
    public void load(BufferedReader reader) throws IOException {
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
    }

}
