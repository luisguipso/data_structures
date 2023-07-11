package org.example.sort;

public class BubbleSort implements Sort {
    public int[] order(int[] numbers) {
        if (numbers == null || numbers.length <= 1)
            return numbers;

        for (int n = 0; n < numbers.length; n++) {
            //on each interaction the last element will be the biggest, so we don't need to change it (length -n -1)
            for (int i = 0; i < numbers.length -1 -n; i++) {
                int nextElement = i + 1;
                if (numbers[i] <= numbers[nextElement])
                    continue;

                switchThem(numbers, i, nextElement);
            }
        }
        return numbers;
    }

    private static void switchThem(int[] numbers, int firstIndex, int secondIndex) {
        int aux = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = aux;
    }
}
