package com.homework.collect;

import java.util.Iterator;

public interface LinkedList<E> extends Iterable<E> {
    void add(E element);
    void add(int index, E element);
    void clear ();
    int indexOf(E element);
    E remove(int index);
    E set(int index, E element);
    int size();
    E[] toArray(E[] ar);
    String toString();
}
