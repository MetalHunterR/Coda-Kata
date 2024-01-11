package org.metalhunterr.list;

import java.util.List;

public interface SimpleList <T> {

    void add(T item);

    void remove(T item);

    T find(T item);

    List<T> valuesOf();

    int getSize();
}
