package org.example.data_structures.list;

public class Node {
    private final int element;
    private Node next;

    Node(int element){
        this.element = element;
        next = null;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return this.next;
    }

    public int getElement() {
        return element;
    }
}
