package org.example.data_structures.list;

public class CircularDoublyLinkedList implements CircularDynamicCollection {

    private DoublyNode first;
    private int size;

    @Override
    public void add(int element) {
        addOnLast(element);
    }

    private DoublyNode addOnLast(int element) {
        DoublyNode newNode = new DoublyNode(element);
        if (isEmpty()) {
            first = newNode;
            first.setNext(newNode);
            first.setPrevious(newNode);
            size++;
            return newNode;
        }
        DoublyNode last = first.getPrevious();
        last.setNext(newNode);
        newNode.setNext(first);
        newNode.setPrevious(last);
        first.setPrevious(newNode);
        size++;
        return newNode;
    }

    @Override
    public void addFirst(int element) {
        first = addOnLast(element);
    }

    @Override
    public int remove() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        int element = first.getElement();

        if(size == 1){
            first = null;
        } else {
            DoublyNode second = (DoublyNode) first.getNext();
            DoublyNode last = first.getPrevious();
            last.setNext(second);
            second.setPrevious(last);
            first = second;
        }
        size--;
        return element;
    }

    @Override
    public int removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        size--;
        DoublyNode last = first.getPrevious();
        DoublyNode newLast = last.getPrevious();
        newLast.setNext(first);
        first.setPrevious(newLast);
        return last.getElement();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
