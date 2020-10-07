package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here -
            //инициализируйте поле users для объекта javaRush тут
            User users = new User();
            users.setFirstName("Vitaliy");
            users.setLastName("Xrenov");
            SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");
            users.setBirthDate(df.parse("27 05 1968"));
            users.setMale(true);
            users.setCountry(User.Country.RUSSIA);

            javaRush.users.add(users);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object
            // - проверьте тут, что javaRush и loadedObject равны
            boolean hash = javaRush.hashCode() == loadedObject.hashCode();
            boolean equal = javaRush.equals(loadedObject);
            System.out.println();
            System.out.println(hash);
            System.out.println(equal);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss:SSS z yyyy", Locale.ENGLISH);
            if(users != null) {
                for (User u : users) {
                    writer.println(u.getFirstName());
                    writer.println(u.getLastName());
                    writer.println(df.format(u.getBirthDate()));
                    writer.println(u.isMale());
                    writer.println(u.getCountry());
                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss:SSS z yyyy", Locale.ENGLISH);
            while(reader.ready()){
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                user.setBirthDate(df.parse(reader.readLine()));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                user.setCountry(User.Country.valueOf(reader.readLine()));
                users.add(user);
            }
            reader.close();
            for(User u : users){
                System.out.println(u.getFirstName());
                System.out.println(u.getLastName());
                System.out.println(u.getBirthDate());
                System.out.println(u.isMale());
                System.out.println(u.getCountry());
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
