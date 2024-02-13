package org.example.data_structures.tree;

public interface BinaryTree {
    void add(int n);

    BinaryTree getLeft();

    BinaryTree getRight();

    boolean hasRightElement();

    boolean hasLeftElement();

    int search(int n);

    boolean isEmpty();

    Integer getValue();
}
