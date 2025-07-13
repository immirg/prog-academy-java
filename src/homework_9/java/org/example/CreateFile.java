package org.example;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFile {
    public static void createNewFile(String name, String text) {
        File file = new File(name);
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(text);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
