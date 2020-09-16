package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person = null;
            if(fileScanner.hasNext()){
                String s = fileScanner.nextLine();
                String[] partsRow = s.split(" ");

                String firstName = partsRow[1];
                String middleName = partsRow[2];
                String lastName = partsRow[0];

                Calendar calendar = new GregorianCalendar(Integer.parseInt(partsRow[5]),
                        Integer.parseInt(partsRow[4]) - 1,
                        Integer.parseInt(partsRow[3]));
                person = new Person(firstName,
                        middleName, lastName, calendar.getTime());
                return person;

            }
            return null;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
