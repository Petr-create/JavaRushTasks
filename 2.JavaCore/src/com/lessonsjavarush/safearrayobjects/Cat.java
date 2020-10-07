package com.lessonsjavarush.safearrayobjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Cat {
    public String name;
    public int age;
    public int weight;

    //удобный механизм сохранения в файл и загрузки из файла
     public void save(PrintWriter writer){
         writer.println(name);
         writer.println(age);
         writer.println(weight);
         writer.flush();
     }

     public void load(BufferedReader reader) throws IOException {
         name = reader.readLine();
         age = Integer.parseInt(reader.readLine());
         weight = Integer.parseInt(reader.readLine());
     }
}
