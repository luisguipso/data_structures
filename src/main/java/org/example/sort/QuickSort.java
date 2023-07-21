package org.example.sort;

public class QuickSort implements Sort {
    @Override
    public int[] order(int[] numbers) {
        if (numbers == null || numbers.length <= 1)
            return numbers;

        quickSort(numbers, 0, numbers.length - 1);


        return numbers;
    }

    private static void quickSort(int[] numbers, int first, int last) {
        if (first >= last)
            return;

        int pivot = partition(numbers, first, last);

        quickSort(numbers, first, pivot - 1);

        quickSort(numbers, pivot + 1, last);
    }

    private static int partition(int[] numbers, int first, int last) {

        int pivot = numbers[first];
        int left = first + 1;
        int right = last;
        while (true) {
            //finds the position of an element which is greater than or equals to the pivot
            while (left <= last && numbers[left] < pivot)
                left++;

            //finds the position of an element which is less than or equals to the pivot
            while (right >= first && numbers[right] > pivot)
                right--;

            if (left >= right)
                break;

            swap(numbers, left, right);
            left++;
            right--;
        }

        swap(numbers, first, right);
        return right;
    }

    private static void swap(int[] numbers, int left, int right) {
        int aux = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = aux;
    }
}
