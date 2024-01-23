package org.example.data_structures.map;

public class LinkedHashMap implements Map {
    private final Node[] values;

    public LinkedHashMap() {
        values = new Node[100];
    }

    public void put(Node newNode) {
        int position = newNode.hashCode();
        Node existingNode = values[position];
        if (existingNode == null) {
            values[position] = newNode;
        } else if (isEquals(existingNode, newNode)) {
            update(existingNode, newNode);
        } else {
            while (existingNode.getNext() != null) {
                if (isEquals(existingNode, newNode)) {
                    update(existingNode, newNode);
                } else
                    existingNode = existingNode.getNext();
            }
            existingNode.setNext(newNode);
        }
    }

    private static boolean isEquals(Node node1, Node node2) {
        return node1.getKey() == node2.getKey();
    }

    private static void update(Node existingNode, Node newNode) {
        existingNode.setValue(newNode.getValue());
    }

    public Node get(int key) {
        Node r = new Node();
        r.setKey(key);
        int position = r.hashCode();
        Node result = values[position];
        if (result == null)
            return null;

        do {
            if (result.getKey() == key)
                return result;
            result = result.getNext();
        } while (result != null);
        return values[position];
    }
}
