package com.helper;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class CustomLinkedList <T> implements Iterable<T>{

    private boolean isEmpty = false;
    private T item = null;
    private CustomLinkedList<T> next = null;
    private CustomLinkedList<T> lastNode = null;

    public CustomLinkedList(){isEmpty = true;}
    public CustomLinkedList(T item){
        this.item = item;
    }

    public void add(T item){

        if(isEmpty){
            this.item = item;
            isEmpty = false;
        }
        else{
            CustomLinkedList<T> newItem = new CustomLinkedList<>(item);

            if(next == null){
                next = newItem;
                lastNode = next;
            }
            else{
                lastNode.next = newItem;
                lastNode = lastNode.next;
                if(next.next == null){
                    next.next = lastNode;
                }
            }
        }
    }

    public void merge(@NotNull CustomLinkedList<T> li){

        if(li.isEmpty){
            return;
        }

        if(isEmpty){
            this.item = li.item;
            this.next = li.next;
            this.lastNode = li.lastNode;
            this.isEmpty = false;
            return;
        }

        if(this.next == null){
            this.next = li;
            if(li.next == null ){
                lastNode = next;
            }
            else{
                this.next.next = li.next;
                lastNode = li.lastNode;
            }
        }
        else{
            this.lastNode.next = li;
            this.lastNode = li.lastNode;
        }
    }

    public CustomLinkedList<T> getNext(){
        return this.next;
    }
    public T getItem(){
        return this.item;
    }

    @Override
    public String toString() {

        if(isEmpty){
            return "[]";
        }

        StringBuilder buf = new StringBuilder("[");
        CustomLinkedList<T> iter = this;

        while(iter != null){
            buf.append(iter.item.toString());
            iter = iter.next;
            if(iter != null){
                buf.append(",");
            }
        }
        buf.append("]");
        return buf.toString();
    }

    //Unchecked assignment: 'com.helper.CustomIterator' to 'java.util.Iterator<T>'
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new CustomIterator(this);
    }
}
