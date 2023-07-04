package org.example.data_structures.list;

public class LinkedList implements DynamicCollection {

    private Node first;
    private int size;
    @Override
    public void add(int element) {
        Node next = new Node(element);
        size++;
        if (first == null) {
            first = next;
            return;
        }

        Node last = first;
        while(last.getNext() != null)
            last = last.getNext();
        last.setNext(next);
    }

    @Override
    public int remove() {
        size--;
        int element = first.getElement();
        first = first.getNext();
        return element;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size(){
        return this.size;
    }
}
