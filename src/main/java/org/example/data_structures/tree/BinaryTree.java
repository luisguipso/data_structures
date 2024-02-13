package org.example.data_structures.tree;

public class BinaryTree {
    private Node root;

    public void add(int n){
        if(isEmpty())
            this.root = new Node(n);
        else
            this.root.add(n);
    }

    public int search(int n){
        if(isEmpty())
            return 0;
        return this.root.search(n);
    }
    public boolean isEmpty(){
        return this.root == null;
    }
}
