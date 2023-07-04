package org.example.data_structures.list;

public interface CircularDynamicCollection extends DynamicCollection{
    int removeLast();

    void addFirst(int element);
}
