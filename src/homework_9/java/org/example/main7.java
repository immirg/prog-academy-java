package org.example;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class main7 {
    public static void main(String[] args) {
        /*
        1. Напишите программу которая скопирует файлы (с заранее определенным разрешением — например только doc) из
        каталога источника в каталог приемник
         */
        String directory = ".";
        String extension = ".doc";
        ArrayList<String> lst = SearchFilesByExtension.foundFiles(extension, directory);

        for (int k = 0; k < lst.size(); k++) {
            File in = new File(lst.get(k));
            File out = new File("new_file_" + k + extension);

            try {
                FlOperation.fileCopy(in, out);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        /*
        2. Напишите программу которая примет на вход 2 текстовых файла, а вернет один. Содержимым этого файла должны
        быть слова которые есть и в первом и во втором файле.
         */

        String file1 = "file_1.txt";
        String file2 = "file_2.txt";
        String file3 = "file_3.txt";

        String text1 = "Напишите программу которая скопирует файлы (с заранее определенным разрешением — например только doc) " +
                "из каталога источника в каталог приемник";
        String text2 = "Напишите программу которая примет на вход 2 текстовых файла, а вернет один. Содержимым этого файла должны " +
                "быть слова которые есть и в первом и во втором файле";

        CreateFile.createNewFile(file1, text1);
        CreateFile.createNewFile(file2, text2);

        String text3 = SearchForSimilarTextInFiles.searchText(file1, file2);
        CreateFile.createNewFile(file3, text3);
    }
}
