package org.example.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class QueueImplTest {

    private Queue queue;

    @BeforeEach
    public void setup(){
        queue = new QueueImpl();
    }

    @Test
    public void newQueueIsEmpty(){
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void newQueueIsNotFull(){
        assertThat(queue.isFull(), is(false));
    }

    @Test
    public void afterAddAnItemQueueIsNotEmpty(){
        queue.add(1);
        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    public void afterAddAnItemQueueIsNotFull(){
        queue.add(1);
        assertThat(queue.isFull(), is(false));
    }

    @Test
    public void afterAddAllItensQueueIsFull(){
        for (int i : new int[]{1,2,3,4,5,6,7,8,9,10})
            queue.add(i);

        assertThat(queue.isFull(), is(true));
    }

    @Test
    public void removeReturnsTheFirstElementAdded(){
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : ints)
            queue.add(i);

        for (int i : ints)
            assertThat(queue.remove(), is(i));
    }

    @Test
    public void addBeforeFilledAllElements(){
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : ints)
            queue.add(i);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.add(11));
    }

    @Test
    public void removeFromAnEmptyQueue(){
        assertThat(queue.isEmpty(), is(true));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.remove());
    }
}
