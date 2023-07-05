package org.example;

import java.util.Random;

public class RamdomArrayGenerator {
    public int[] gen(int size, boolean print) {
        int[] numbers = new int[size];

        for(int i = 0; i < size; i++){
            numbers[i] = new Random().nextInt(size*3);
        }

        if (print)
            print(numbers);
        return numbers;
    }

    private static void print(int[] numbers) {
        for (int i : numbers) {
            System.out.print(i + "  ");
        }
    }
}
