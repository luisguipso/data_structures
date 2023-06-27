package org.example;

import org.example.stack.StackImpl;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        StackImpl stack = new StackImpl();
        Scanner scanner = new Scanner(System.in);
        int numberInDecimal = scanner.nextInt();
        while (numberInDecimal != 0) {
            if(!stack.isFull())
                stack.push(numberInDecimal % 2);
            numberInDecimal /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println("\nThe end of program!");
    }
}
