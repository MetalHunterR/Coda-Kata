package org.metalhunterr.list.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicLinkedList<T> extends SingleLinkedList<T> {

    @Override
    public void add(T item) {
        SingleListNode newNode = new SingleListNode();
        newNode.nodeValue = item;

        if (head == null) {
            head = newNode;
        } else {
            SingleListNode current = head;

            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = newNode;
            newNode.nextNode = head;
        }
        currentSize++;
    }

    @Override
    public void remove(T item) {
        SingleListNode current = head;
        SingleListNode previous = null;

        while ((current != null && current.nextNode.equals(head)) && !current.nodeValue.equals(item)) {
            previous = current;
            current = current.nextNode;
        }

        if (current != null) {
            if (previous == null) {
                head = current.nextNode;
            } else {
                previous.nextNode = current.nextNode;
            }
            currentSize--;
        } else {
            throw new NoSuchElementException("Item not found");
        }
    }

    @Override
    public T find(T item) {
        SingleListNode current = head;

        while ((current != null && current.nextNode.equals(head)) && !current.nodeValue.equals(item)) {
            current = current.nextNode;
        }

        boolean bFound = current != null;
        if (bFound) {
            return current.nodeValue;
        }
        return null;
    }

    @Override
    public List<T> valuesOf() {
        List<T> result = new ArrayList<>();
        SingleListNode current = head;

        while (current != null && !current.nextNode.equals(head)) {
            result.add(current.nodeValue);
            current = current.nextNode;
        }
        return result;
    }
}
