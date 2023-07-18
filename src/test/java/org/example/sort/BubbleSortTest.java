package org.example.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class BubbleSortTest {

    private Sort bs;

    @BeforeEach
    void setup(){
        bs = new BubbleSort();
    }

    @Test
    void cantOrderEmptyArray(){
        int[] numbers = new int[] {};
        assertThat(bs.order(numbers), is(numbers));
    }

    @Test
    void cantOrderNullArray(){
        int[] numbers = null;
        assertThat(bs.order(numbers), is(numbers));
    }

    @Test
    void shouldOrderArrayWithOneElement(){
        int[] numbers = new int[] {1};
        assertThat(bs.order(numbers), is(new int[]{1}));
    }

    @Test
    void shouldOrderArrayWithTwoElements(){
        int[] numbers = new int[] {2,1};
        int[] orderedNumbers = {1, 2};
        assertThat(bs.order(numbers), is(orderedNumbers));
    }

    @Test
    void shouldOrderArrayWithThreeElements(){
        int[] numbers = new int[] {2,3,1};
        int[] orderedNumbers = {1,2,3};
        assertThat(bs.order(numbers), is(orderedNumbers));
    }

    @Test
    void shouldOrderArrayWithLotsOfElements(){
        int[] numbers = new int[] {2,3,1,45,342,23,75,89,56,34,68};
        int[] orderedNumbers = {1,2,3,23,34,45,56,68,75,89,342};
        assertThat(bs.order(numbers), is(orderedNumbers));
    }
}
