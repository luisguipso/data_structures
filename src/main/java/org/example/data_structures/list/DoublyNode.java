package org.example.data_structures.list;

public class DoublyNode extends Node {

    private DoublyNode previous;

    DoublyNode(int element) {
        super(element);
    }

    public void setPrevious(DoublyNode previous) {
        this.previous = previous;
    }

    public DoublyNode getPrevious() {
        return previous;
    }
}
