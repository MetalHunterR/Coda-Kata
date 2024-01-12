package org.metalhunterr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    @DisplayName("Iterative Variant")
    public void iterativeBinarySearch() {
        assertEquals(-1, Main.binarySearch(-1, new int[] { }));
        assertEquals(-1, Main.binarySearch(-1, new int[] { 1 }));
        assertEquals(-1, Main.binarySearch(0, new int[] { 1 }));

        assertEquals(0, Main.binarySearch(1, new int[] { 1, 3, 5 }));
        assertEquals(1, Main.binarySearch(3, new int[] { 1, 3, 5 }));
        assertEquals(2, Main.binarySearch(5, new int[] { 1, 3, 5 }));
    }


    @Test
    @DisplayName("Iterative Variant")
    public void iterativeBinarySearchBadSearch() {
        assertEquals(2, Main.binarySearch(6, new int[] { 1, 3, 5 }));
    }

    @Test
    @DisplayName("Recursive Variant")
    public void recursiveBinarySearch() {
        assertEquals(-1, Main.recursiveBinarySearch(-1,0, 0,  new int[] { }));
        assertEquals(-1, Main.recursiveBinarySearch(-1, 0, 1,  new int[] { 1 }));
        assertEquals(-1, Main.recursiveBinarySearch(0, 0, 1,  new int[] { 1 }));

        assertEquals(0, Main.recursiveBinarySearch(1, 0, 2, new int[] { 1, 3, 5 }));
        assertEquals(1, Main.recursiveBinarySearch(3, 0, 2, new int[] { 1, 3, 5 }));
        assertEquals(2, Main.recursiveBinarySearch(5, 0, 2, new int[] { 1, 3, 5 }));
    }

    @Test
    @DisplayName("Chunk Variant")
    public void chunkBinarySearch() {
        assertEquals(-1, Main.recursiveFunctionalBinarySearch(-1,0, 0,  new int[] { }));
        assertEquals(-1, Main.recursiveFunctionalBinarySearch(-1, 0, 1,  new int[] { 1 }));
        assertEquals(-1, Main.recursiveFunctionalBinarySearch(0, 0, 1,  new int[] { 1 }));

        assertEquals(0, Main.recursiveFunctionalBinarySearch(1, 0, 2, new int[] { 1, 3, 5 }));
        assertEquals(1, Main.recursiveFunctionalBinarySearch(3, 0, 2, new int[] { 1, 3, 5 }));
        assertEquals(1, Main.recursiveFunctionalBinarySearch(5, 0, 2, new int[] { 1, 3, 5 }));
    }

    @Test
    @DisplayName("Random Variant")
    public void randomBinarySearch() {
        assertEquals(-1, Main.randomBinarySearch(-1, new int[] { }));
        assertEquals(-1, Main.randomBinarySearch(-1, new int[] { 1 }));
        assertEquals(-1, Main.randomBinarySearch(0, new int[] { 1 }));

        assertEquals(0, Main.randomBinarySearch(1, new int[] { 1, 3, 5 }));
        assertEquals(1, Main.randomBinarySearch(3, new int[] { 1, 3, 5 }));
        assertEquals(2, Main.randomBinarySearch(5, new int[] { 1, 3, 5 }));
    }
}