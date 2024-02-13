package org.example.data_structures.tree;

public class Node {

    private final int value;
    private Node left;
    private Node right;

    public Node(int n) {
        this.value = n;
    }

    public void add(int n) {
        if (isBiggerThanThis(n))
            addOnRight(n);
        else if (isLessThanThis(n))
            addOnLeft(n);
    }

    private boolean isLessThanThis(int n) {
        return n < this.value;
    }

    private void addOnLeft(int n) {
        if (this.left == null)
            this.left = new Node(n);
        else
            this.left.add(n);
    }

    private boolean isBiggerThanThis(int n) {
        return n > this.value;
    }

    private void addOnRight(int n) {
        if (this.right == null)
            this.right = new Node(n);
        else
            this.right.add(n);
    }

    public int search(int n) {
        if (this.value == n)
            return this.value;
        else if (mustBeOnRight(n))
            return this.right.search(n);
        else if (mustBeOnLeft(n))
            return this.left.search(n);
        else return 0;
    }

    private boolean mustBeOnLeft(int n) {
        return isLessThanThis(n) && this.left != null;
    }

    private boolean mustBeOnRight(int n) {
        return isBiggerThanThis(n) && this.right != null;
    }
}
