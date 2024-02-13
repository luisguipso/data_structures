package org.example;


import org.example.data_structures.map.LinkedHashMap;
import org.example.data_structures.map.Node;
import org.example.data_structures.queue.StaticCollection;
import org.example.data_structures.queue.StaticQueue;
import org.example.data_structures.stack.Stack;
import org.example.data_structures.stack.StackImpl;
import org.example.data_structures.tree.BinaryTree;
import org.example.data_structures.tree.BinaryTreeImpl;
import org.example.data_structures.tree.BinaryTreePrinter;


import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //decimalToBinaryUsingStack();
        //addOneMilionElementsToAQueueAndDequeue();
        //showHash();
        //testBitWize();
        testBinaryTree();
    }

    private static void testBinaryTree() {
        BinaryTree tree = new BinaryTreeImpl();
        tree.add(5);
        tree.add(2);
        tree.add(3);
        tree.add(9);
        tree.add(5);
        tree.add(8);
        tree.add(7);
        tree.add(10);

        System.out.println("Printing tree in pre-order");
        BinaryTreePrinter.print(tree);
        System.out.println("Printing tree in in-order");
        BinaryTreePrinter.print(tree, BinaryTreePrinter.IN_ORDER);
        System.out.println("Printing tree in post-order");
        BinaryTreePrinter.print(tree, BinaryTreePrinter.POST_ORDER);
        System.out.println("Printing tree in inverted in-order");
        BinaryTreePrinter.print(tree, BinaryTreePrinter.INVERTED_IN_ORDER);
    }

    private static void testBitWize() {
        byte a = 64, b;
        String e = "123";
        int x = 255555555;
        int i;

        i = e.hashCode() >>> 16;
        System.out.println("i " + i);
        System.out.println(e.hashCode() ^ i);
        HashMap map = new HashMap();
        map.put(e, e);

    }

    private static void showHash() {
        Node reg1 = new Node(7865, "Luis");
        Node reg2 = new Node(123, "Cyntia");
        Node reg3 = new Node(987, "Samuel");
        Node reg4 = new Node(887, "Davi");
        System.out.println("Registro " + reg1.getKey() + " - " + reg1.getValue() + " (" + reg1.hashCode() + ")");
        System.out.println("Registro " + reg2.getKey() + " - " + reg2.getValue() + " (" + reg2.hashCode() + ")");
        System.out.println("Registro " + reg3.getKey() + " - " + reg3.getValue() + " (" + reg3.hashCode() + ")");
        System.out.println("Registro " + reg4.getKey() + " - " + reg4.getValue() + " (" + reg4.hashCode() + ")");
        LinkedHashMap map = new LinkedHashMap();
        map.put(reg1);
        map.put(reg2);
        map.put(reg3);
        map.put(reg4);
        Scanner scanner = new Scanner(System.in);
        int key;
        do {
            key = scanner.nextInt();
            Node r = map.get(key);
            if (r != null) System.out.println("Found: " + r.getKey() + " = " + r.getValue());
            else System.out.println("Not found.");

        } while (key != -1);
    }

    private static void addOneMilionElementsToAQueueAndDequeue() {
        StaticCollection queue = new StaticQueue(1_000_000);
        System.out.println("adding 1 Milion elements to the queue");
        for (int i = 0; i < 1_000_000; i++)
            queue.add(i);
        System.out.println("Start removing the elements...");
        while (!queue.isEmpty()) System.out.println(queue.remove());
        System.out.println("\nThe end of program!");
    }

    private static void decimalToBinaryUsingStack() {
        Stack stack = new StackImpl(100);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a decimal number, to be converted to binary: ");
        int numberInDecimal = scanner.nextInt();

        while (numberInDecimal != 0) {
            if (!stack.isFull()) stack.push(numberInDecimal % 2);
            numberInDecimal /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
