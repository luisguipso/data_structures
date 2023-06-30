package org.example.list;

public class CircularDoublyLinkedList implements CircularDynamicCollection {

    private DoublyNode first;
    private int size;

    @Override
    public void add(int element) {
        DoublyNode newNode = new DoublyNode(element);
        if (isEmpty()) {
            first = newNode;
            size++;
            return;
        }
        DoublyNode last = getLastNode();
        last.setNext(newNode);
        newNode.setPrevious(last);
        first.setPrevious(newNode);
        size++;
    }

    @Override
    public void addFirst(int element) {
        if (isEmpty()) {
            add(element);
            return;
        }
        size++;
        DoublyNode newNode = new DoublyNode(element);
        newNode.setNext(first);
        newNode.setPrevious(first.getPrevious());
        first.setPrevious(newNode);
        first = newNode;
    }

    private DoublyNode getLastNode() {
        DoublyNode last = first;
        while (last.getNext() != null) {
            last = (DoublyNode) last.getNext();
        }
        return last;
    }

    @Override
    public int remove() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        size--;
        int element = first.getElement();
        setNewFirstNode();
        return element;

    }

    private void setNewFirstNode() {
        DoublyNode newFirst = (DoublyNode) first.getNext();

        if (!isEmpty())
            newFirst.setPrevious(first.getPrevious());

        first = newFirst;
    }

    @Override
    public int removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        size--;
        DoublyNode last = first.getPrevious();
        Node newLast = last.getPrevious();
        newLast.setNext(null);
        first.setPrevious((DoublyNode) newLast);
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
