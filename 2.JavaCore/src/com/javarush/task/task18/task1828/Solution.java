package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length != 4){
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<String> list = new ArrayList<>();
        String str;
        BufferedReader reader2 = new BufferedReader(new FileReader(fileName));
        while ((str = reader2.readLine()) != null){
            list.add(str);
        }
        reader2.close();

        int idInput = Integer.parseInt(args[1].substring(0, 8).trim());

        if(args[0].equals("-u")){
            for (int i = 0; i < list.size(); i++) {
                int id = Integer.parseInt(list.get(i).substring(0, 8).trim());
                if(idInput == id) {
                    list.set(i, String.format("%-8d%-30s%-8.2f%-4d", id, args[1],
                            Double.parseDouble(args[2]), Integer.parseInt(args[3])));
                    writeToFile(list, fileName);
                    break;
                }
            }
        }
        if(args[0].equals("-d")){
            for(String s : list){
                int id = Integer.parseInt(s.substring(0, 8).trim());
                if(idInput == id){
                    list.remove(s);
                    writeToFile(list, fileName);
                    break;
                }
            }

        }
    }

    public static void writeToFile(ArrayList<String> list, String fileName) throws IOException {
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
