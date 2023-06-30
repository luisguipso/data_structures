package org.example.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class CircularDoublyLinkedListTest {

    private CircularDynamicCollection dll;

    @BeforeEach
    void setup() {
        dll = new CircularDoublyLinkedList();
    }

    @Test
    void whenCreatedShouldBeEmpty() {
        assertThat(dll.isEmpty(), is(true));
    }

    @Test
    void afterAddAnElementShouldNotBeEmpty() {
        dll.add(1);
        assertThat(dll.isEmpty(), is(false));
    }

    @Test
    void afterRemoveShouldBeEmptyAgain(){
        dll.add(1);
        dll.remove();
        assertThat(dll.isEmpty(), is(true));
    }

    @Test
    void shouldRemoveTheFirstElement() {
        dll.add(1);
        dll.add(2);
        dll.add(3);
        assertThat(dll.remove(), is(1));
        assertThat(dll.remove(), is(2));
        assertThat(dll.remove(), is(3));
    }

    @Test
    void cannotRemoveFromAnEmptyList() {
        Assertions.assertThrows(RuntimeException.class, () -> dll.remove());
    }

    @Test
    void shouldRemoveTheLastElement() {
        dll.add(1);
        dll.add(2);
        dll.add(3);
        assertThat(dll.removeLast(), is(3));
        assertThat(dll.removeLast(), is(2));
        assertThat(dll.removeLast(), is(1));
    }

    @Test
    void shouldRemoveFirstAndThenTheLastElement() {
        dll.add(1);
        dll.add(2);
        dll.add(3);
        assertThat(dll.remove(), is(1));
        assertThat(dll.removeLast(), is(3));
        assertThat(dll.removeLast(), is(2));
    }

    @Test
    void shouldRemoveLastAndThenTheFirstElement() {
        dll.add(1);
        dll.add(2);
        dll.add(3);
        assertThat(dll.removeLast(), is(3));
        assertThat(dll.remove(), is(1));
        assertThat(dll.remove(), is(2));
    }

    @Test
    void shouldBeAbleToAddOnFirst(){
        dll.add(1);
        dll.add(2);
        dll.addFirst(3);
        assertThat(dll.remove(), is(3));
        assertThat(dll.remove(), is(1));
        assertThat(dll.remove(), is(2));
    }


    @Test
    void shouldBeAbleToAddOnFirstTwice(){
        dll.addFirst(6);
        assertThat(dll.isEmpty(), is(false));
        assertThat(dll.size(), is(1));
        dll.add(1);
        dll.add(2);
        dll.addFirst(3);
        dll.add(4);
        dll.addFirst(5);
        assertThat(dll.size(), is(6));

        assertThat(dll.remove(), is(5));
        assertThat(dll.remove(), is(3));
        assertThat(dll.remove(), is(6));
        assertThat(dll.remove(), is(1));
        assertThat(dll.remove(), is(2));
        assertThat(dll.remove(), is(4));
        assertThat(dll.size(), is(0));
        assertThat(dll.isEmpty(), is(true));
    }

}
