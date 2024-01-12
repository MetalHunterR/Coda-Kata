package org.metalhunterr;

import java.io.File;
import java.math.BigInteger;
import java.util.*;
import java.util.zip.CRC32;

public class Main {
    static final int MAGIC_NUMbER = 69; // Very mature...

    static byte[] bloomBuffer = new byte[Integer.MAX_VALUE / 2];

    public static void main(String[] args) {
        readWordFile("wordlist.txt").forEach(word -> {
            int finalHash = generateHash(word);
            bloomBuffer[finalHash] = 1;
        });


        String testKey = "A's";
        int testHash = generateHash(testKey);
        if (bloomBuffer[testHash] == 1) {
            System.out.printf("%s is in the list%n", testKey);
        }
    }

    private static ArrayList<String> readWordFile(String fileName) {
        ArrayList<String> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String wordKey = scanner.next();
                result.add(wordKey);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    private static int generateHash(String word) {
        int bytes = 0;
        for (int i = 0; i < word.length(); i++ ) {
            bytes =+ word.charAt(i);
        }

        return Math.abs(bytes % (bloomBuffer.length - 1));
    }
}