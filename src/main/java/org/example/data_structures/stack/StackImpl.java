package org.example.data_structures.stack;

public class StackImpl implements Stack {
    private int numberOfElements;
    private final int[] elements;

    public StackImpl(){
        numberOfElements = 0;
        elements = new int[10];
    }

    public StackImpl(int maxNumberOfElements) {
        numberOfElements = 0;
        elements = new int[maxNumberOfElements];

    }

    public void push(int newElement) {
        elements[numberOfElements] = newElement;
        numberOfElements++;
    }

    public int pop() {
        numberOfElements--;
        int poppedElement = elements[numberOfElements];
        elements[numberOfElements] = 0;
        return poppedElement;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean isFull() {
        return numberOfElements == elements.length;
    }
}
