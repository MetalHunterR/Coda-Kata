package org.metalhunterr;

import org.metalhunterr.generator.CRC32HashGenerator;

import java.io.File;
import java.util.*;

public class Main {

    static byte[] bloomBuffer = new byte[258 * 1024];

    public static void main(String[] args) {
        readWordFile().forEach(word -> {
            int firstHash = generateFirstHash(word);
            bloomBuffer[firstHash] = 1;
        });


        String testKey = "ABA";
        int testHash = generateFirstHash(testKey);
        if (bloomBuffer[testHash] == 1) {
            System.out.printf("%s is probably in the list%n", testKey);
        }
    }

    private static ArrayList<String> readWordFile() {
        ArrayList<String> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("wordlist.txt"))) {
            while (scanner.hasNextLine()) {
                String wordKey = scanner.next();
                result.add(wordKey);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    private static int generateFirstHash(String word) {
        return (int) (CRC32HashGenerator.generateHash(word) % bloomBuffer.length);
    }
}