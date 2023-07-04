package org.example.search;

public class BinarySearch {
    int search(int[] numbers, int numberToFind) {
        if (numbers == null)
            throw new IllegalArgumentException("The array must not be null!");

        if (numbers.length == 0)
            return -1;

        int first = 0;
        int last = numbers.length-1;
         do {
            int index = (last-first)/2;
            if(numberToFind == numbers[index])
                return index;

            if(numberToFind > numbers[index])
                first = index;
            if(numberToFind < numbers[index])
                last = index;
        } while(first != last);


        return -1;
    }
}
