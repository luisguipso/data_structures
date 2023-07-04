package org.example.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class BinarySearchTest {

    private BinarySearch src;

    @BeforeEach
    void setup(){
        src = new BinarySearch();
    }

    @Test
    void withANullArrayShouldThrowException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> src.search(null, 1));
    }

    @Test
    void emptyArrayReturnsNegativeOne() {
        assertThat(src.search(new int[]{}, 1), is(-1));
    }

    @Test
    void arrayWithTwoReturnsTheIndexOfTwo() {
        int[] arrayWithTwo = {2};
        assertThat(src.search(arrayWithTwo, 2), is(0));
    }

    @Test
    void arrayWithTwoArgumentsReturnsTheIndexOfTheSearchedNumber() {
        int[] withTwoAndThree = {2, 3};
        assertThat(src.search(withTwoAndThree, 3), is(1));
    }

    @Test
    void bigArrayReturnsTheIndexOfTheSearchedNumber() {
        int[] numbers = {2, 3, 123, 235, 23412, 12341, 123, 23, 123, 12, 67, 8879, 56, 453, 34, 98};
        assertThat(src.search(numbers, 3), is(1));
        assertThat(src.search(numbers, 123), is(2));
        assertThat(src.search(numbers, 56), is(12));
        assertThat(src.search(numbers, 34), is(14));
        assertThat(src.search(numbers, 98), is(15));
    }

}
