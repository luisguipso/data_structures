package org.example.data_structures.map;

public class HashMap implements Map {
    private final Node[] values;

    public HashMap() {
        values = new Node[100];
    }

    public void put(Node node) {
        int position = node.hashCode();
        values[position] = node;
    }

    public Node get(int key) {
        Node r = new Node();
        r.setKey(key);
        int position = r.hashCode();
        return values[position];
    }
}