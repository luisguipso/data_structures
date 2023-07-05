package org.example;

import org.example.sort.BubbleSort;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class SortExecutionTimeChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("print arrays ('y' or 'n'): ");
        boolean printArrays = in.next().equalsIgnoreCase("y");
        System.out.print("type the size of the array to generate: ");
        int size = in.nextInt();

        RamdomArrayGenerator rand = new RamdomArrayGenerator();
        int[] generated = rand.gen(size, printArrays);

        Date startedAt = new Date(System.currentTimeMillis());
        System.out.println("\nSorting started at: " + startedAt);

        int[] ordered = new BubbleSort().order(generated);
        Date finishedAt = new Date(System.currentTimeMillis());

        if(printArrays) {
            Arrays.stream(ordered).forEach(e -> System.out.print(e + "  "));
            System.out.println("");
        }
        System.out.println("Sorting finished at: " + finishedAt);
        System.out.println("Elapsed time: " + (finishedAt.getTime()-startedAt.getTime()) + "ms.");


    }
}
