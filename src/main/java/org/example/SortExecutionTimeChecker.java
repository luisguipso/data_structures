package org.example;

import org.example.sort.BubbleSort;
import org.example.sort.InsertionSort;
import org.example.sort.SelectionSort;
import org.example.sort.Sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class SortExecutionTimeChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean printArrays = askIfShouldPrintArrays(in);
        int size = askTheArraySize(in);
        int[] generated = genARandomArray(size);
        if (printArrays) printArray(generated);
        Sort sortMethod = getSortMethod(in);
        int[] ordered = sortArray(sortMethod, generated);
        if (printArrays) printArray(ordered);
    }

    private static boolean askIfShouldPrintArrays(Scanner in) {
        log("print arrays ('y' or 'n'): ");
        return in.next().equalsIgnoreCase("y");
    }

    private static int askTheArraySize(Scanner in) {
        log("type the size of the array to generate: ");
        return in.nextInt();
    }

    private static int[] genARandomArray(int size) {
        return new RamdomArrayGenerator(size).gen();
    }

    private static void printArray(int[] ordered) {
        Arrays.stream(ordered).forEach(e -> log(e + "  "));
    }

    private static Sort getSortMethod(Scanner in) {
        Sort sort;
        String lBreak = "\n";
        String[] algs = new String[] {" 0 - Bubble Sort", " 1 - Selection Sort", " 2 - Insertion Sort"};

        askAlgorithmsToUse(lBreak, algs);
        int chosen = in.nextInt();
        sort = createSort(chosen);

        log("Will use: ".concat(algs[chosen]));
        return sort;
    }

    private static Sort createSort(int chosen) {
        return switch (chosen) {
            case 1 -> new SelectionSort();
            case 2 -> new InsertionSort();
            default -> new BubbleSort();
        };
    }

    private static int[] sortArray(Sort sort, int[] generated) {
        Date startedAt = getActualTime();
        log("Sorting started at: ".concat(startedAt.toString()));

        int[] ordered = sort.order(generated);

        Date finishedAt = getActualTime();
        log("Sorting finished at: ".concat(finishedAt.toString()));
        logElapsedTime(startedAt, finishedAt);
        return ordered;
    }

    private static Date getActualTime() {
        return new Date(System.currentTimeMillis());
    }

    private static void log(String s) {
        System.out.println(s);
    }

    private static void logElapsedTime(Date startedAt, Date finishedAt) {
        long elapsedTime = finishedAt.getTime() - startedAt.getTime();
        String toStr = String.valueOf(elapsedTime);
        String msg = "Elapsed time: ".concat(toStr).concat("ms.");
        log(msg);
    }

    private static void askAlgorithmsToUse(String lBreak, String[] algs) {
        StringBuilder sb = new StringBuilder();
        sb.append("Type the algorithm to use")
          .append(lBreak);
        Arrays.stream(algs)
                .forEach(a -> sb.append(a).append(lBreak));
        log(sb.toString());
    }

}
