package org.example;

import org.example.data_structures.queue.StaticCollection;
import org.example.data_structures.queue.StaticQueue;
import org.example.data_structures.stack.Stack;
import org.example.data_structures.stack.StackImpl;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        //decimalToBinaryUsingStack();
        //addOneMilionElementsToAQueueAndDequeue();
    }

    private static void addOneMilionElementsToAQueueAndDequeue() {
        StaticCollection queue = new StaticQueue(1_000_000);
        System.out.println("adding 1 Milion elements to the queue");
        for (int i = 0; i < 1_000_000; i++)
            queue.add(i);
        System.out.println("Start removing the elements...");
        while(!queue.isEmpty())
            System.out.println(queue.remove());
        System.out.println("\nThe end of program!");
    }

    private static void decimalToBinaryUsingStack() {
        Stack stack = new StackImpl(100);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a decimal number, to be converted to binary: ");
        int numberInDecimal = scanner.nextInt();

        while (numberInDecimal != 0) {
            if(!stack.isFull())
                stack.push(numberInDecimal % 2);
            numberInDecimal /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
