package org.example.data_structures.queue;

public class StaticQueue implements StaticCollection {
    private int numberOfElements;
    private final int maxNumberOfElements;
    private final int[] elements;

    public StaticQueue() {
        numberOfElements = 0;
        maxNumberOfElements = 10;
        elements = new int[maxNumberOfElements];
    }
    public StaticQueue(int maxNumberOfElements) {
        numberOfElements = 0;
        this.maxNumberOfElements = maxNumberOfElements;
        elements = new int[maxNumberOfElements];
    }

    @Override
    public void add(int element) {
        elements[numberOfElements] = element;
        numberOfElements++;
    }

    @Override
    public int remove() {
        numberOfElements--;
        int positionOfElementToRemove = maxNumberOfElements - numberOfElements - 1;
        return elements[positionOfElementToRemove];
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean isFull() {
        return numberOfElements == elements.length;
    }
}
