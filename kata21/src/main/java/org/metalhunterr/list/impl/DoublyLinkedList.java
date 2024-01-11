package org.metalhunterr.list.impl;

import org.metalhunterr.list.SimpleList;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> extends SingleLinkedList<T> {

    private class ListNode extends SingleListNode {
        SingleListNode prevNode;
    }

    private ListNode head;

    @Override
    public void add(T item) {
        ListNode newNode = new ListNode();
        newNode.nodeValue = item;

        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;

            while (current.nextNode != null) {
                current = (ListNode) current.nextNode;
            }
            current.nextNode = newNode;
            newNode.prevNode = current;
        }
        currentSize++;
    }

    @Override
    public void remove(T item) {
        ListNode current = head;

        while (current != null && !current.nodeValue.equals(item)) {
            current = (ListNode) current.nextNode;
        }

        if (current != null) {
            if (current.prevNode == null) {
                head = (ListNode) current.nextNode;
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
    public List<T> valuesOf() {
        List<T> result = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            result.add(current.nodeValue);
            current = (ListNode) current.nextNode;
        }
        return result;
    }
}
