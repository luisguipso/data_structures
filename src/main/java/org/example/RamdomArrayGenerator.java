package org.example;

import java.util.Random;

public class RamdomArrayGenerator {
    private final int size;

    public RamdomArrayGenerator(int size) {
        this.size = size;
    }

    public int[] gen() {
        int[] numbers = new int[size];

        for(int i = 0; i < size; i++){
            numbers[i] = new Random().nextInt(size*3);
        }

        return numbers;
    }
}
