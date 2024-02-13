package org.example.data_structures.tree;

public class BinaryTreeImpl implements BinaryTree {
    private Integer value;
    private BinaryTreeImpl left;
    private BinaryTreeImpl right;

    public BinaryTreeImpl() {

    }

    BinaryTreeImpl(Integer n) {
        this();
        this.value = n;
    }

    @Override
    public void add(int n) {
        if (isEmpty()) this.value = n;
        else addOnSubTrees(n);
    }

    @Override
    public boolean isEmpty() {
        return this.value == null;
    }

    private void addOnSubTrees(int n) {
        if (isBiggerThanThis(n)) addOnRight(n);
        else if (isLessThanThis(n)) addOnLeft(n);
    }

    private boolean isBiggerThanThis(int n) {
        return n > this.value;
    }

    private void addOnRight(int n) {
        if (hasRightElement()) this.right.add(n);
        else this.right = new BinaryTreeImpl(n);
    }

    @Override
    public boolean hasRightElement() {
        return this.right != null;
    }

    private boolean isLessThanThis(int n) {
        return n < this.value;
    }
    private void addOnLeft(int n) {
        if (hasLeftElement()) this.left.add(n);
        else this.left = new BinaryTreeImpl(n);
    }

    @Override
    public boolean hasLeftElement() {
        return this.left != null;
    }

    @Override
    public int search(int n) {
        if (isEmpty()) return 0;
        else if (this.value == n) return this.value;
        else if (mustBeOnRight(n)) return this.right.search(n);
        else if (mustBeOnLeft(n)) return this.left.search(n);
        else return 0;
    }

    private boolean mustBeOnRight(int n) {
        return isBiggerThanThis(n) && hasRightElement();
    }

    private boolean mustBeOnLeft(int n) {
        return isLessThanThis(n) && hasLeftElement();
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public BinaryTreeImpl getLeft() {
        return this.left;
    }

    @Override
    public BinaryTreeImpl getRight() {
        return this.right;
    }
}
