package org.example.sort;

public class SelectionSort implements Sort{
    public int[] order(int[] numbers) {
        if (numbers == null || numbers.length <= 1)
            return numbers;

        for (int i = 0; i < numbers.length - 1; i++) {
            int lowestValueIndex = i;
            for (int x = i + 1; x < numbers.length; x++) {
                if(numbers[x] < numbers[lowestValueIndex])
                    lowestValueIndex = x;
            }
            if(numbers[i] > numbers[lowestValueIndex]){
                int smallerNumber = numbers[i];
                numbers[i] = numbers[lowestValueIndex];
                numbers[lowestValueIndex] = smallerNumber;
            }
        }
        return numbers;
    }
}
