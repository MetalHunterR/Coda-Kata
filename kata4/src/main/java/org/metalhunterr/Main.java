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
        System.out.println(getSmallestValueByIndexes(readDataFromFile("weather.dat"), WEATHER_MIN_COLUMN, WEATHER_MAX_COLUMN, true));
        System.out.println(getSmallestValueByIndexes(readDataFromFile("football.dat"), FOOTBALL_AGAINST_COLUMN, FOOTBALL_FOR_COLUMN, false));
    }

    public static ArrayList<ArrayList<String>> readDataFromFile(String fileName) {
        String line;
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                List<String> tempList = Arrays.asList(line.trim().replace("\\s+", "").split("\\s+"));

                if (tempList.size() > 1) {
                    result.add(new ArrayList<String>(tempList));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    public static String getSmallestValueByIndexes(ArrayList<ArrayList<String>> inputData, int maxValueColumnIdx, int minValueColumnIdx, boolean bAllowNegativeValues) {
        String foundResult = "";
        int minDifferenceValue = Integer.MAX_VALUE;

        for(ArrayList<String> dataLine : inputData) {
            try {
                int localMaxDifferenceValue = Integer.parseInt(dataLine.get(maxValueColumnIdx));
                int localMinDifferenceValue = Integer.parseInt(dataLine.get(minValueColumnIdx));
                int localDifference = localMaxDifferenceValue - localMinDifferenceValue;

                if (localDifference > 0 && minDifferenceValue > localDifference) {
                        minDifferenceValue = localDifference;
                        foundResult = bAllowNegativeValues ? dataLine.getFirst() : dataLine.get(1);
                }
            } catch (Exception ex) {
                continue; // Never do this...
            }
        }

        return foundResult;
    }
}