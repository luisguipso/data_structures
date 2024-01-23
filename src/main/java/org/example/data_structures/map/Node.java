package org.example.data_structures.map;

import java.util.Objects;

public class Node {
    private int key;
    private String value;
    private Node next;
    public Node() {
        this.next = null;
    }

    public Node(int key, String value) {
        this();
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key == node.key && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return this.key % 100;
    }
}
