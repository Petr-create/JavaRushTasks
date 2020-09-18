package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        PrintStream par = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        testString.printSomething();
        String string = baos.toString();
        fileOutputStream.write(string.getBytes());
        System.setOut(par);
        System.out.println(string);
        reader.close();
        fileOutputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

