package org.example.sort;

public class BubbleSort implements Sort {
    public int[] order(int[] numbers) {
        if (numbers == null || numbers.length <= 1)
            return numbers;

        for (int n = 0; n < numbers.length; n++) {
            //on each interaction the last element will be the biggest, so we don't need to change it (length -n -1)
            for (int i = 0; i < numbers.length -1 -n; i++) {
                if (numbers[i] <= numbers[i + 1])
                    continue;

                int aux = numbers[i];
                numbers[i] = numbers[i + 1];
                numbers[i + 1] = aux;
            }
        }
        return numbers;
    }
}
