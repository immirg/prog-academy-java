package org.example;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearchForSimilarTextInFiles {
    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }

    public static String searchText(String fileName1, String fileName2) {
        String text1 = readFile(fileName1);
        String text2 = readFile(fileName2);

        String[] arrFile1 = text1.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "").toLowerCase().split(" ");
        String[] arrFile2 = text2.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "").toLowerCase().split(" ");

        Set<String> commonText = new HashSet<>();
        for (int i = 0; i < arrFile1.length; i++) {
            for (int j = 0; j < arrFile2.length; j++) {
                if (arrFile1[i].equals(arrFile2[j])) {
                    commonText.add(arrFile1[i]);
                }
            }
        }
        return String.join(" ", commonText);
    }
}
