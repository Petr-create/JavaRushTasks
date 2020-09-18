package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileOut));
        while (fileReader.ready()){
            String str = fileReader.readLine();
            str = str.replaceAll("[\\p{Punct}\\n]", "");
            fileWriter.write(str);
            fileWriter.newLine();
        }
        fileReader.close();
        fileWriter.close();
    }
}
