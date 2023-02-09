package Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public abstract class Algorithms {

    public static ArrayList<Integer> readFileArr(File f) throws IOException {
        ArrayList<Integer> arr = new ArrayList<>();
        for(String s : Files.readAllLines(f.toPath())) {
            arr.add(Integer.parseInt(s));
        }
        return arr;
    }

    public static ArrayList<String> readFileArrString(File f) throws IOException {
        return new ArrayList<>(Files.readAllLines(f.toPath()));
    }

    public static String readFileString(File f) throws IOException {
        StringBuilder bobTheBuilder = new StringBuilder();
        for(String s : Files.readAllLines(f.toPath())) {
            //arr.add(Integer.parseInt(s));
            bobTheBuilder.append(s);
        }
        return bobTheBuilder.toString();
    }
}
