package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            throw new IllegalArgumentException();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedReader buff = new BufferedReader(fileReader);

        String result;

        while((result = buff.readLine()) != null){
            if(result.startsWith(args[0] + " ")){
                System.out.println(result);
                break;
            }
        }
        reader.close();
        fileReader.close();
        buff.close();

    }
}
