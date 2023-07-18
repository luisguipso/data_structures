package org.example.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class QuickSortTest {
    private Sort qs;

    @BeforeEach
    void setup(){
        qs = new QuickSort();
    }

    @Test
    void cantOrderEmptyArray(){
        int[] numbers = new int[] {};
        assertThat(qs.order(numbers), is(numbers));
    }

    @Test
    void cantOrderNullArray(){
        int[] numbers = null;
        assertThat(qs.order(numbers), is(numbers));
    }

    @Test
    void shouldOrderArrayWithOneElement(){
        int[] numbers = new int[] {1};
        assertThat(qs.order(numbers), is(new int[]{1}));
    }

    @Test
    void shouldOrderArrayWithTwoElements(){
        int[] numbers = new int[] {2, 1};
        int[] orderedNumbers = {1, 2};
        assertThat(qs.order(numbers), is(orderedNumbers));
    }

    @Test
    void shouldOrderArrayWithThreeElements(){
        int[] numbers = new int[] {2,3,1};
        int[] orderedNumbers = {1,2,3};
        assertThat(qs.order(numbers), is(orderedNumbers));
    }

    @Test
    void shouldOrderArrayWithLotsOfElements(){
        int[] numbers = new int[] {2,3,1,45,342,23,75,89,56,34,68};
        int[] orderedNumbers = {1,2,3,23,34,45,56,68,75,89,342};
        assertThat(qs.order(numbers), is(orderedNumbers));
    }

    @Test
    void shouldNotFreezeWhenSorting20itemsArray(){
        int[] array = new int[] {4, 17, 2, 48, 9, 41, 17, 8, 28, 53, 17, 50, 14, 34, 34, 21, 7, 54, 31, 1};
        int[] ordered = {1, 2, 4, 7, 8, 9, 14, 17, 17, 17, 21, 28, 31, 34, 34, 41, 48, 50, 53, 54};
        assertThat(qs.order(array), is(ordered));
    }
}
