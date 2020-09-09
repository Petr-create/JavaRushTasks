package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length != 4){
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        int max = 0;
        ArrayList<String> list = new ArrayList<>();
        String str;
        BufferedReader readerId = new BufferedReader(new FileReader(fileName));
        while ((str = readerId.readLine()) != null){
            list.add(str);
        }
        readerId.close();

        for(String s : list){
            int id = Integer.parseInt(s.substring(0, 8).trim());
            if(max < id){
                max = id;
            }
        }

        list.add(String.format("%-8d%-30s%-8.2f%-4d", max + 1, args[1],
                Double.parseDouble(args[2]), Integer.parseInt(args[3])));
        if(args[0].equals("-c")) {
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s);
                sb.append("\n");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(sb.toString());
            writer.close();
        }

    }
}
