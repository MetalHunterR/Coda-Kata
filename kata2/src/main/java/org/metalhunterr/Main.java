package org.metalhunterr;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int binarySearch(int lookingFor, int[] array) {
        if (array.length == 0) {
            return -1;
        }

        int idx = -1;

        // Used for searching
        int left = 0;
        int right = array.length;
        int center = (left + right) / 2;

        while (left <= right && array[center] != lookingFor) {
            if (array[center] > lookingFor) {
                right = center - 1;
            } else {
                left = center + 1;
            }

            center = (left + right) / 2;
        }

        if (left <= right) {
            idx = center;
        }

        return idx;
    }

    public static int recursiveBinarySearch(int lookingFor, int left, int right, int[] array) {
        if (array.length == 0 || left > right) {
            return -1;
        }

        int center = (left + right) / 2;
        if (array[center] == lookingFor) {
            return center;
        } else {
            if (array[center] > lookingFor) {
                return recursiveBinarySearch(lookingFor, left, center - 1, array);
            } else {
                return recursiveBinarySearch(lookingFor, center + 1, right, array);
            }
        }
    }

    public static int recursiveFunctionalBinarySearch(int lookingFor, int left, int right, int[] array) {
        if (array.length == 0 || left > right) {
            return -1;
        }

        int center = (left + right) / 2;
        if (array[center] == lookingFor) {
            return center;
        } else {
            int[] arrayChunk;
            if (array[center] > lookingFor) {
                arrayChunk = Arrays.copyOfRange(array, left, center );
                return recursiveFunctionalBinarySearch(lookingFor, left, center, arrayChunk);
            } else {
                arrayChunk = Arrays.copyOfRange(array, center, right + 1);
                return recursiveFunctionalBinarySearch(lookingFor, center, right, arrayChunk);
            }
        }
    }

    public static int randomBinarySearch(int lookingFor, int[] array) {
        if (array.length == 0) {
            return -1;
        }

        int idx = -1;
        Random r = new Random();

        // Used for searching
        int left = 0;
        int right = array.length;
        int current = r.nextInt(right);

        while (left <= right && array[current] != lookingFor) {
            if (array[current] > lookingFor) {
                right = current - 1;
            } else {
                left = current - 1;
            }

            current = r.nextInt(Math.abs(right - left)) + left;
        }

        if (left <= right) {
            idx = current;
        }

        return idx;
    }
}