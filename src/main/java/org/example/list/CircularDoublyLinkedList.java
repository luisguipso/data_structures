package org.example.list;

public class CircularDoublyLinkedList implements DynamicCollection{

    private DoublyNode first;
    private int size;

    @Override
    public void add(int element) {
        size++;
        DoublyNode newNode = new DoublyNode(element);
        if(first == null){
            first = newNode;
            return;
        }
        DoublyNode last = first;
        while(last.getNext() != null){
            last = (DoublyNode) last.getNext();
        }
        last.setNext(newNode);
        first.setPrevious(last);
    }

    @Override
    public int remove() {
        if (first != null) {
            int element = first.getElement();
            first = (DoublyNode) first.getNext();
            return element;
        }
        throw new RuntimeException("Empty List");
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return 0;
    }
}
