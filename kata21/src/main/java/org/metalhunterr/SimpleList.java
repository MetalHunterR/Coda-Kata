package org.metalhunterr;

import java.lang.reflect.Array;

public interface SimpleList <T> {

    void add(T item);

    void remove(T item);

    T valueOf();

    Array<T> valuesOf();
}
