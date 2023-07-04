package org.example.data_structures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackImplTest {

    private Stack stack;

    @BeforeEach
    void setUp(){
        stack = new StackImpl();
    }

    @Test
    void newStackIsEmpty() {


        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    void afterAddAnItemStackIsNotEmpty() {
        stack.push(1);

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    void afterAddAllItensStackIsNotEmpty() {
        for (int i = 0; i < 10; i++)
            stack.push(i);

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    void newStackIsNotFull() {
        assertThat(stack.isFull(), is(false));
    }

    @Test
    void afterAddJustSomeElementsStackShouldNotBeFull() {
        for (int i = 0; i < 5; i++)
            stack.push(i);

        assertThat(stack.isFull(), is(false));
    }

    @Test
    void afterAddAllElementsStackShouldBeFull() {
        for (int i = 0; i < 10; i++)
            stack.push(i);

        assertThat(stack.isFull(), is(true));
    }

    @Test
    void popRetunsTheLastInsertedItem() {
        stack.push(1);
        stack.push(2);
        stack.push(3);


        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }


    @Test
    void shouldBePossibleToCreateAStackOfOtherSide(){
        Stack stackOfAHundredElements = new StackImpl(100);
        assertThat(stackOfAHundredElements.isEmpty(), is(true));

        for (int i = 0; i <= 99; i++)
            stackOfAHundredElements.push(i);

        assertThat(stackOfAHundredElements.isFull(), is(true));
        assertThat(stackOfAHundredElements.isEmpty(), is(false));
        for(int i = 99; i >= 0; i--)
            assertThat(stackOfAHundredElements.pop(), is(i));
    }

    @Test
    void pushOnAFullStack(){
        for(int i : new int[] {1,2,3,4,5,6,7,8,9,10})
            stack.push(i);

        assertThat(stack.isFull(), is(true));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.push(11));

    }

    @Test
    void popInAnEmptyStack(){
        assertThat(stack.isEmpty(), is(true));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.pop());
    }

}
