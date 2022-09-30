package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    static BufferedReader filebuffer;

    static {
        try {
            filebuffer = new BufferedReader(new FileReader("calculator.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static List<String> inputLines = new ArrayList<>();

    static String line;
    public List<String> readLines() throws IOException {
        while (true) {
            try {
                if (!((line = filebuffer.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            inputLines.add(line);
        }
        //System.out.println("Lines " + inputLines.get(0));

        filebuffer.close();
        return inputLines;
    }


    public List<String[]> split(List<String> inputLines) {
        List<String[]> inputLinesSplitted = new ArrayList<>();
        for (String s : inputLines) {
            inputLinesSplitted.add(s.split(" "));
        }
        //System.out.println(inputLinesSplitted);
        return inputLinesSplitted;
    }


}
