package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<FileInputStream> streams = new ArrayList<>();
        String file = null;

        try{
            while(true) {
                file = reader.readLine();
                FileInputStream fis = new FileInputStream(file);
                streams.add(fis);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(file);
            for (FileInputStream str : streams) {
                str.close();
            }
        }
    }
}
