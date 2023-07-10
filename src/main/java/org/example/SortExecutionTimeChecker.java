package org.example;

import org.example.sort.BubbleSort;
import org.example.sort.SelectionSort;
import org.example.sort.Sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class SortExecutionTimeChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean printArrays = getOptionForPrintingArrays(in);
        int size = askSizeOfArray(in);
        int[] generated = generateAnArrayOfIntegers(printArrays, size);

        Date startedAt = new Date(System.currentTimeMillis());
        System.out.println("\nSorting started at: " + startedAt);

        Sort sort = getSortMethod(in);

        int[] ordered = sort.order(generated);

        Date finishedAt = new Date(System.currentTimeMillis());
        if (printArrays) printSortedArray(ordered);
        System.out.println("Sorting finished at: " + finishedAt);
        System.out.println("Elapsed time: " + (finishedAt.getTime() - startedAt.getTime()) + "ms.");
    }

    private static void printSortedArray(int[] ordered) {
        Arrays.stream(ordered).forEach(e -> System.out.print(e + "  "));
        System.out.println("");
    }

    private static Sort getSortMethod(Scanner in) {
        Sort sort;
        System.out.print("Type the algorithm to use\n 0 - Bubble Sort,\n 1 - Selection Sort]\n: ");
        switch (in.nextInt()) {
            case 1:
                sort = new SelectionSort();
                break;
            default:
                sort = new BubbleSort();
        }
        return sort;
    }

    private static int[] generateAnArrayOfIntegers(boolean printArrays, int size) {
       return new RamdomArrayGenerator().gen(size, printArrays);
    }

    private static int askSizeOfArray(Scanner in) {
        System.out.print("type the size of the array to generate: ");
        return in.nextInt();
    }

    private static boolean getOptionForPrintingArrays(Scanner in) {
        System.out.print("print arrays ('y' or 'n'): ");
        return in.next().equalsIgnoreCase("y");
    }
}
