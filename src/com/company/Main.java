package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<File> folderList = Arrays.asList(
                new File("C:\\Владимир\\Обучение\\Games\\src"),
                new File("C:\\Владимир\\Обучение\\Games\\res"),
                new File("C:\\Владимир\\Обучение\\Games\\savegames"),
                new File("C:\\Владимир\\Обучение\\Games\\temp"),
                new File("C:\\Владимир\\Обучение\\Games\\src\\main"),
                new File("C:\\Владимир\\Обучение\\Games\\src\\test"),
                new File("C:\\Владимир\\Обучение\\Games\\res\\drawables"),
                new File("C:\\Владимир\\Обучение\\Games\\res\\vectors"),
                new File("C:\\Владимир\\Обучение\\Games\\res\\icons"));

        List<File> fileList = Arrays.asList(
                new File("C:\\Владимир\\Обучение\\Games\\src\\main\\Main.java"),
                new File("C:\\Владимир\\Обучение\\Games\\src\\main\\Utils.java"),
                new File("C:\\Владимир\\Обучение\\Games\\temp\\temp.txt"));

        StringBuilder sb = new StringBuilder();

        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) {
                sb.append("Каталог " + folder.getName() + " создан\n");
            } else {
                sb.append("Каталог " + folder.getName() + " не создан\n");
            }
        });

        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) {
                    sb.append("Файл " + file.getName() + " создан\n");
                } else {
                    sb.append("Файл " + file.getName() + " не создан\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        try (FileWriter writer = new FileWriter("C:\\Владимир\\Обучение\\Games\\temp\\temp.txt", false)) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileReader reader = new FileReader("C:\\Владимир\\Обучение\\Games\\temp\\temp.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
