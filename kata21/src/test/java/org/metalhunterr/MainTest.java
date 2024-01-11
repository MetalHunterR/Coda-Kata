package org.metalhunterr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.metalhunterr.list.SimpleList;
import org.metalhunterr.list.impl.CyclicLinkedList;
import org.metalhunterr.list.impl.DoublyLinkedList;
import org.metalhunterr.list.impl.SingleLinkedList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Single List Test (Add Items)")
    void singleListTestAddItems() {
        SimpleList<String> testList = new SingleLinkedList<>();
        testList.add("fred");
        assertEquals("fred", testList.find("fred"));

        testList.add("wilma");
        assertEquals(new ArrayList<String>() {{ add("fred"); add("wilma"); }}, testList.valuesOf());
    }

    @Test
    @DisplayName("Single List Test (Delete Items)")
    void singleListTestDeleteItems() {
        SimpleList<String> testList = new SingleLinkedList<>();
        testList.add("fred");
        assertEquals("fred", testList.find("fred"));

        testList.add("wilma");
        assertEquals(new ArrayList<String>() {{ add("fred"); add("wilma"); }}, testList.valuesOf());
        assertEquals(2, testList.getSize());

        testList.remove("fred");

        assertEquals(1, testList.getSize());
        assertNull(testList.find("fred"));
    }

    @Test
    @DisplayName("Doubly List Test (Add Items)")
    void doublyListTestAddItems() {
        SimpleList<String> testList = new DoublyLinkedList<>();
        testList.add("fred");
        assertEquals("fred", testList.find("fred"));

        testList.add("wilma");
        assertEquals(new ArrayList<String>() {{ add("fred"); add("wilma"); }}, testList.valuesOf());
    }

    @Test
    @DisplayName("Doubly List Test (Delete Items)")
    void doublyListDeleteItems() {
        SimpleList<String> testList = new DoublyLinkedList<>();
        testList.add("fred");
        assertEquals("fred", testList.find("fred"));

        testList.add("wilma");
        assertEquals(new ArrayList<String>() {{ add("fred"); add("wilma"); }}, testList.valuesOf());
        assertEquals(2, testList.getSize());

        testList.remove("fred");

        assertEquals(1, testList.getSize());
        assertNull(testList.find("fred"));
    }

    @Test
    @DisplayName("Cyclic List Test (Add Items)")
    void cyclicListTestAddItems() {
        SimpleList<String> testList = new CyclicLinkedList<>();
        testList.add("fred");
        assertEquals("fred", testList.find("fred"));

        testList.add("wilma");
        assertEquals(new ArrayList<String>() {{ add("fred"); add("wilma"); }}, testList.valuesOf());
    }

    @Test
    @DisplayName("Cyclic List Test (Delete Items)")
    void cyclicListDeleteItems() {
        SimpleList<String> testList = new CyclicLinkedList<>();
        testList.add("fred");
        assertEquals("fred", testList.find("fred"));

        testList.add("wilma");
        testList.add("betty");
        assertEquals(new ArrayList<String>() {{ add("fred"); add("wilma"); add("betty"); }}, testList.valuesOf());
        assertEquals(3, testList.getSize());

        testList.remove("wilma");

        assertEquals(2, testList.getSize());
        assertNull(testList.find("wilma"));
    }
}