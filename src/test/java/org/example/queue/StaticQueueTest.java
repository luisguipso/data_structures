package org.example.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


class StaticQueueTest {

    private StaticCollection queue;

    @BeforeEach
    void setup(){
        queue = new StaticQueue();
    }

    @Test
    void newQueueIsEmpty(){
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    void newQueueIsNotFull(){
        assertThat(queue.isFull(), is(false));
    }

    @Test
    void afterAddAnItemQueueIsNotEmpty(){
        queue.add(1);
        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    void afterAddAnItemQueueIsNotFull(){
        queue.add(1);
        assertThat(queue.isFull(), is(false));
    }

    @Test
    void afterAddAllItensQueueIsFull(){
        for (int i : new int[]{1,2,3,4,5,6,7,8,9,10})
            queue.add(i);

        assertThat(queue.isFull(), is(true));
    }

    @Test
    void removeReturnsTheFirstElementAdded(){
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : ints)
            queue.add(i);

        for (int i : ints)
            assertThat(queue.remove(), is(i));
    }

    @Test
    void addBeforeFilledAllElements(){
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : ints)
            queue.add(i);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.add(11));
    }

    @Test
    void removeFromAnEmptyQueue(){
        assertThat(queue.isEmpty(), is(true));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.remove());
    }
}
