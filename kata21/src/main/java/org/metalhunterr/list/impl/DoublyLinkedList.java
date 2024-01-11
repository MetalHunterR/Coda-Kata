package org.metalhunterr.list.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> extends SingleLinkedList<T> {

    private class DoublyListNode extends SingleListNode {
        SingleListNode prevNode;
    }

    private DoublyListNode head;

    @Override
    public void add(T item) {
        DoublyListNode newNode = new DoublyListNode();
        newNode.nodeValue = item;

        if (head == null) {
            head = newNode;
        } else {
            DoublyListNode current = head;

            while (current.nextNode != null) {
                current = (DoublyListNode) current.nextNode;
            }
            current.nextNode = newNode;
            newNode.prevNode = current;
        }
        currentSize++;
    }

    @Override
    public void remove(T item) {
        DoublyListNode current = head;

        while (current != null && !current.nodeValue.equals(item)) {
            current = (DoublyListNode) current.nextNode;
        }

        if (current != null) {
            if (current.prevNode == null) {
                head = (DoublyListNode) current.nextNode;
                head.prevNode = null;
            } else {
                current.prevNode.nextNode = current.nextNode;
            }
            currentSize--;
        } else {
            throw new NoSuchElementException("Item not found");
        }
    }

    @Override
    public T find(T item) {
        DoublyListNode current = head;

        while (current != null && !current.nodeValue.equals(item)) {
            current = (DoublyListNode) current.nextNode;
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
        DoublyListNode current = head;

        while (current != null) {
            result.add(current.nodeValue);
            current = (DoublyListNode) current.nextNode;
        }
        return result;
    }
}
