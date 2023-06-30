package org.example.list;

public interface CircularDynamicCollection extends DynamicCollection{
    int removeLast();

    void addFirst(int element);
}
