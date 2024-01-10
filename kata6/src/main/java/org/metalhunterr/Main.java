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
            String tmpStr;

            while(reader.hasNextLine()) {
                String baseWord = reader.nextLine().toLowerCase();
                char[] tmpCharArray = baseWord.toCharArray();
                Arrays.sort(tmpCharArray);
                tmpStr = new String(tmpCharArray);

                if (!result.containsKey(tmpStr)) {
                    result.put(tmpStr, new ArrayList<>());
                }

                result.get(tmpStr).add(baseWord);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    /*
    private static ArrayList<String> findAnagrams(String baseWord, ArrayList<String> wordList) {
        ArrayList<String> result = new ArrayList<>();

        wordList.forEach((checkWord) -> {
            if (!baseWord.equals(checkWord) && baseWord.length() == checkWord.length()) {

                char[] baseTmp = baseWord.toCharArray();
                char[] checkTmp = checkWord.toCharArray();

                Arrays.sort(baseTmp);
                Arrays.sort(checkTmp);

                String sortedBase = new String(baseTmp);
                String sortedCheck = new String(checkTmp);

                if (sortedBase.equals(sortedCheck)) {
                    result.add(checkWord);
                }
            }
        });

        return result;
    }
     */
}