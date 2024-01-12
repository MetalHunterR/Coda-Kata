package org.metalhunterr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static final int WEATHER_MIN_COLUMN = 1;
    static final int WEATHER_MAX_COLUMN = 2;
    static final int FOOTBALL_FOR_COLUMN = 6;
    static final int FOOTBALL_AGAINST_COLUMN = 8;

    public static void main(String[] args) {
        System.out.println(getSmallestValueByIndexes(readDataFromFile("weather.dat"), WEATHER_MIN_COLUMN, WEATHER_MAX_COLUMN, false));
        System.out.println(getSmallestValueByIndexes(readDataFromFile("football.dat"), FOOTBALL_FOR_COLUMN, FOOTBALL_AGAINST_COLUMN, true));
    }

    public static ArrayList<ArrayList<String>> readDataFromFile(String fileName) {
        String line;
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                List<String> tempList = Arrays.asList(line
                        .trim()
                        .replaceAll("\\*", "")
                        .split("\\s+"));

                if (tempList.size() > 1) {
                    result.add(new ArrayList<>(tempList));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    public static String getSmallestValueByIndexes(ArrayList<ArrayList<String>> inputData, int maxValueColumnIdx, int minValueColumnIdx, boolean bUseUniqueResult) {
        String foundResult = "";
        double minDifferenceValue = Double.MAX_VALUE;

        for(int i = 1; i < inputData.size(); i++) {
            double localMaxDifferenceValue = Double.parseDouble(inputData.get(i).get(maxValueColumnIdx));
            double localMinDifferenceValue = Double.parseDouble(inputData.get(i).get(minValueColumnIdx));
            double localDifference = Math.abs(localMaxDifferenceValue - localMinDifferenceValue);

            if (minDifferenceValue > localDifference) {
                minDifferenceValue = localDifference;
                foundResult = bUseUniqueResult ? inputData.get(i).get(1) : inputData.get(i).getFirst();
            }
        }

        return foundResult;
    }
}
