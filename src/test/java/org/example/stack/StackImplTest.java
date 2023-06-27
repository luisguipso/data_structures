package org.example.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackImplTest {

    private Stack stack;

    @BeforeEach
    public void setUp(){
        stack = new StackImpl();
    }

    @Test
    public void newStackIsEmpty() {


        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void afterAddAnItemStackIsNotEmpty() {
        stack.push(1);

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void afterAddAllItensStackIsNotEmpty() {
        for (int i = 0; i < 10; i++)
            stack.push(i);

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void newStackIsNotFull() {
        assertThat(stack.isFull(), is(false));
    }

    @Test
    public void afterAddJustSomeElementsStackShouldNotBeFull() {
        for (int i = 0; i < 5; i++)
            stack.push(i);

        assertThat(stack.isFull(), is(false));
    }

    @Test
    public void afterAddAllElementsStackShouldBeFull() {
        for (int i = 0; i < 10; i++)
            stack.push(i);

        assertThat(stack.isFull(), is(true));
    }

    @Test
    public void popRetunsTheLastInsertedItem() {
        stack.push(1);
        stack.push(2);
        stack.push(3);


        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }


    @Test
    public void shouldBePossibleToCreateAStackOfOtherSide(){
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
    public void pushOnAFullStack(){
        for(int i : new int[] {1,2,3,4,5,6,7,8,9,10})
            stack.push(i);

        assertThat(stack.isFull(), is(true));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.push(11));

    }

    @Test
    public void popInAnEmptyStack(){
        assertThat(stack.isEmpty(), is(true));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.pop());
    }

}
