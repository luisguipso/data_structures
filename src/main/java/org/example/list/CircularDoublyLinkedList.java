package org.example.list;

public class CircularDoublyLinkedList implements CircularDynamicCollection {

    private DoublyNode first;
    private int size;

    @Override
    public void add(int element) {
        size++;
        DoublyNode newNode = new DoublyNode(element);
        if (first == null) {
            first = newNode;
            return;
        }
        DoublyNode last = first;
        while (last.getNext() != null) {
            last = (DoublyNode) last.getNext();
        }
        last.setNext(newNode);
        newNode.setPrevious(last);
        first.setPrevious(newNode);
    }

    @Override
    public int remove() {
        if (first != null) {
            int element = first.getElement();
            first = (DoublyNode) first.getNext();
            size--;
            return element;
        }
        throw new RuntimeException("Empty List");
    }

    @Override
    public int removeLast() {
        if (first == null)
            throw new RuntimeException("Empty List");
        DoublyNode last;

        if(first.getPrevious() == null){
            last = first;
            first = null;
            return last.getElement();
        }

        last = first.getPrevious();
        Node prev = last.getPrevious();
        prev.setNext(null);

        if(!first.equals(prev))
            first.setPrevious((DoublyNode) prev);
        else
            first.setPrevious(null);

        return last.getElement();
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
