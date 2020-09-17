package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        String str = "";
        while(fileReader.ready()){
            char oneSymbol = (char) fileReader.read();
            str += String.valueOf(oneSymbol).toLowerCase();
        }
        str = str.replaceAll("\\p{Punct}", " ");
        str = str.replaceAll("\n", " ");
        String[] text = str.split(" ");
        int count = 0;
        for(String s : text){
            s = s.trim();
            if(s.equals("world")){
                count++;
            }
        }
        System.out.println(count);
        fileReader.close();
    }
}
