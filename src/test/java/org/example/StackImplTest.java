package org.example;

import org.example.stack.StackImpl;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackImplTest {

    @Test
    public void newStackIsEmpty() {
        StackImpl stack = new StackImpl();

        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void afterAddAnItemStackIsNotEmpty() {
        StackImpl stack = new StackImpl();
        stack.push(1);
        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void afterAddAllItensStackIsNotEmpty() {
        StackImpl stack = new StackImpl();

        for (int i = 0; i < 10; i++)
            stack.push(i);

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void newStackIsNotFull() {
        StackImpl stack = new StackImpl();

        assertThat(stack.isFull(), is(false));
    }

    @Test
    public void afterAddJustSomeElementsStackShouldNotBeFull() {
        StackImpl stack = new StackImpl();
        for (int i = 0; i < 5; i++)
            stack.push(i);

        assertThat(stack.isFull(), is(false));
    }

    @Test
    public void afterAddAllElementsStackShouldBeFull() {
        StackImpl stack = new StackImpl();
        for (int i = 0; i < 10; i++)
            stack.push(i);

        assertThat(stack.isFull(), is(true));
    }

    @Test
    public void popRetunsTheLastInsertedItem() {
        StackImpl stack = new StackImpl();

        stack.push(1);
        stack.push(2);
        stack.push(3);


        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }


    @Test
    public void shouldBePossibleToCreateAStackOfOtherSide(){
        StackImpl stackOfAHundredElements = new StackImpl(100);
        assertThat(stackOfAHundredElements.isEmpty(), is(true));

        for (int i = 0; i <= 99; i++)
            stackOfAHundredElements.push(i);

        assertThat(stackOfAHundredElements.isFull(), is(true));
        assertThat(stackOfAHundredElements.isEmpty(), is(false));
        for(int i = 99; i >= 0; i--)
            assertThat(stackOfAHundredElements.pop(), is(i));
    }

}
