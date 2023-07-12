package org.example.sort;

public class InsertionSort implements Sort {
    public int[] order(int[] numbers) {
        if (numbers == null || numbers.length <= 1)
            return numbers;

        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0 && numbers[j - 1] > numbers[j]; j--) {
                int aux = numbers[j - 1];
                numbers[j - 1] = numbers[j];
                numbers[j] = aux;
            }
        }
        return numbers;
    }
}
