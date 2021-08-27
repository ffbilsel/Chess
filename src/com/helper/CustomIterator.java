package com.helper;

import java.util.Iterator;

public class CustomIterator<T> implements Iterator<T> {

    private CustomLinkedList<T> head;

    public CustomIterator(CustomLinkedList <T> head){
        this.head = head;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }

    @Override
    public T next() { T item = head.getItem(); head = head.getNext(); return item; }
}
