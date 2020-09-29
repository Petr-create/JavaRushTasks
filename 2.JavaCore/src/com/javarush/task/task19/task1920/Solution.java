package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        while (reader.ready()){
            String[] tmp = reader.readLine().split(" ");
            if(!map.containsKey(tmp[0])){
                map.put(tmp[0], Double.parseDouble(tmp[1]));
            }
            else {
                map.put(tmp[0], map.get(tmp[0]) + Double.parseDouble(tmp[1]));
            }
        }
        Double max = 0.0;

        for (Map.Entry<String, Double> pair : map.entrySet()){
            max = Math.max(max, pair.getValue());
        }


        for (Map.Entry<String, Double> pair : map.entrySet()){
                if(pair.getValue().equals(max)){
                    System.out.println(pair.getKey());
                }
        }
        reader.close();
    }
}
