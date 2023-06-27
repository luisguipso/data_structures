package org.example.queue;

public interface Queue {
    void add(int element);
    int remove();
    boolean isEmpty();
    boolean isFull();
}
