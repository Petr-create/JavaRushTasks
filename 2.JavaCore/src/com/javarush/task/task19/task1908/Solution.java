package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileOut));
        String str = "";
        while(fileReader.ready()){
            char oneSymbol = (char) fileReader.read();
            str += oneSymbol;
        }
        str = str.replaceAll("\n", " ");
        String[] text = str.split(" ");
        for(String s : text){
            s = s.trim();
            if(number(s)){
                fileWriter.write(s + " ");
            }
        }
        fileReader.close();
        fileWriter.close();
    }
    public static boolean number (String string){
        try{
            Integer.parseInt(string);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
