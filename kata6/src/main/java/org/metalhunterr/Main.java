package org.metalhunterr;

import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        readTextFile().forEach((key, value) -> {
            StringBuilder sb = new StringBuilder();
            sb.append("-".repeat(15));
            sb.append(String.format("%nKey value: %s%nWords: ", key));
            value.forEach((word) -> sb.append(word).append(", "));
            System.out.println(sb);
        });
        LocalDateTime stop = LocalDateTime.now();

        System.out.println(ChronoUnit.MILLIS.between(start, stop));
    }

    private static HashMap<String, ArrayList<String>> readTextFile() {
        HashMap<String, ArrayList<String>>  result = new HashMap<>();

        try(Scanner reader = new Scanner(new File("wordlist.txt"))) {
            String[] keyWord = createKeyFromWord(reader.nextLine());

            while(reader.hasNextLine()) {
                if (!result.containsKey(keyWord[0])) {
                    result.put(keyWord[0], new ArrayList<>());
                }

                result.get(keyWord[0]).add(keyWord[1]);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    private static String[] createKeyFromWord(String baseWord) {
        char[] tmpCharArray = baseWord.toLowerCase().toCharArray();
        Arrays.sort(tmpCharArray);
        return new String[] { new String(tmpCharArray), baseWord };
    }
}