package org.example.sort;

public class SelectionSort implements Sort{
    public int[] order(int[] numbers) {
        if (numbers == null || numbers.length <= 1)
            return numbers;

        for (int i = 0; i < numbers.length - 1; i++) {
            int lowestValueIndex = getLowestValueIndex(numbers, i);
            if(numbers[i] > numbers[lowestValueIndex]){
                switchThem(numbers, i, lowestValueIndex);
            }
        }
        return numbers;
    }

    private static void switchThem(int[] numbers, int firstIndex, int secondIndex) {
        int smallerNumber = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = smallerNumber;
    }

    private static int getLowestValueIndex(int[] numbers, int i) {
        int lowestValueIndex = i;
        for (int x = i + 1; x < numbers.length; x++) {
            if(numbers[x] < numbers[lowestValueIndex])
                lowestValueIndex = x;
        }
        return lowestValueIndex;
    }
}
