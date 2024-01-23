package org.example.data_structures.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LinkedHashMapTest {

    private Map map;

    @BeforeEach
    void setup(){
        map = new LinkedHashMap();
    }

    @Test
    void whenMapIsEmpty_getNull(){
        assertNull(map.get(123));
    }

    @Test
    void getValuesFromMap(){
        Node input1 = new Node(123, "value 123");
        Node input2 = new Node(124, "value 124");

        map.put(input1);
        map.put(input2);

        assertEquals(input1, map.get(123));
        assertEquals(input2, map.get(124));
    }

    @Test
    void getValuesFromMapMultipleTimes(){
        Node input1 = new Node(123, "value 123");
        Node input2 = new Node(124, "value 124");

        for(int i = 0; i < 10; i++) {
            map.put(input1);
            map.put(input2);

            assertEquals(input1, map.get(123));
            assertEquals(input2, map.get(124));
        }
    }

    @Test
    void whenUnexistentNode_getNull(){
        Node input1 = new Node(123, "value 123");
        Node input2 = new Node(124, "value 124");

        map.put(input1);
        map.put(input2);

        assertNull(map.get(125));
    }

    @Test
    void whenNodeIsAlreadyOnMap_ThenUpdate(){
        Node value = new Node(123, "value 123");
        Node newValue = new Node(123, "new value 123");

        map.put(value);
        map.put(newValue);

        assertEquals(newValue, map.get(123));
    }

    @Test
    void whenUpdateNode_OtherNodesKeepSame(){
        Node value123 = new Node(123, "value 123");
        Node newValue123 = new Node(123, "new value 123");
        Node value124 = new Node(124, "value 124");
        Node value125 = new Node(125, "value 125");

        map.put(value123);
        map.put(value124);
        map.put(value125);
        map.put(newValue123);

        assertEquals(newValue123, map.get(123));
        assertEquals(value124, map.get(124));
        assertEquals(value125, map.get(125));
    }

    @Test
    void whenNodeHasSameHash_ThenAdd(){
        Node value123 = new Node(123, "value 123");
        Node value223 = new Node(223, "value 223");

        map.put(value123);
        map.put(value223);

        assertEquals(value123.hashCode(), value223.hashCode());
        assertEquals(value123, map.get(123));
        assertEquals(value223, map.get(223));
    }
}
