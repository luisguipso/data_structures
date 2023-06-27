package org.example;

import org.example.stack.Stack;
import org.example.stack.StackImpl;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        //decimalToBinaryUsingStack();
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
