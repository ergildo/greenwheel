package com.greenwheel.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static List<String> readAllLines(String filename) throws FileNotFoundException {
        File file = new File(filename);
        return readAllLines(file);
    }

    public static List<String> readAllLines(File file) throws FileNotFoundException {

        List<String> lines = new ArrayList<String>();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }
        scanner.close();
        return lines;

    }

    public static void writeLine(String filename, String line) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(filename, true));
        pw.println(line);
        pw.close();
    }

    public static <T> String getGreenWheelFilePath() {
        try {
            return Paths.get(getCurrentPath(), "greewheel.txt").toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getCurrentPath() {
        return System.getProperty("user.home");
    }
}
