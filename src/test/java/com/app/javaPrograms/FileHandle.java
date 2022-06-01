package com.app.javaPrograms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandle {
    public static void main(String a[]) throws IOException {
        File file = new File("/Users/indiramb/Downloads/3A/temp.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("1234 Balakrishnan");
        fileWriter.write("\n");
        fileWriter.flush();
    }
}
