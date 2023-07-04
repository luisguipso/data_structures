package org.example.search;

public class LinearSearch {
    public int search(int[] numbers, int numberToFind) {
        if (numbers == null)
            throw new IllegalArgumentException("The array must not be null!");

        for(int i = 0; i < numbers.length; i++)
            if(numbers[i] == numberToFind)
                return i;

        return -1;
    }
}
