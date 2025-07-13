package org.example;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SearchFilesByExtension {
    public static ArrayList<String> foundFiles(String fileExtension, String directory){
        File dir = new File(directory);
        ArrayList<String> lst = new ArrayList<>();

        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isFile()) {
                if (String.valueOf(file).endsWith(fileExtension)) {

                    try {
                        lst.add(file.getCanonicalPath());
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        return lst;
    }
}
