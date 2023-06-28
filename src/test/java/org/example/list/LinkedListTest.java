package org.example.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class LinkedListTest {

    private DynamicCollection list;

    @BeforeEach
    public void setup(){
        list = new LinkedList();
    }

    @Test
    void onCreatedIsEmpty(){
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    void afterAddAnElementIsNotEmpty(){

        list.add(1);
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    void shouldRemoveTheFirstElement(){
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.remove(), is(1));
        assertThat(list.remove(), is(2));
        assertThat(list.remove(), is(3));
    }


    @Test
    void shouldMatchTheSize(){
        assertThat(list.size(), is(0));
        list.add(1);
        assertThat(list.size(), is(1));
        list.add(2);
        assertThat(list.size(), is(2));
        list.add(3);
        assertThat(list.size(), is(3));
        list.remove();
        assertThat(list.size(), is(2));
        list.remove();
        assertThat(list.size(), is(1));
        list.remove();
        assertThat(list.size(), is(0));
    }


    @Test
    void shouldBeEmptyAfterRemoveAllElements(){
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.isEmpty(), is(false));

        list.remove();
        list.remove();
        list.remove();

        assertThat(list.isEmpty(), is(true));
    }
}
