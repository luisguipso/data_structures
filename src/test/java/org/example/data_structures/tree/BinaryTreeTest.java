package org.example.data_structures.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeTest {
    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    void testAddAndSearch() {
        binaryTree.add(10);
        binaryTree.add(5);
        binaryTree.add(15);

        assertEquals(10, binaryTree.search(10));
        assertEquals(5, binaryTree.search(5));
        assertEquals(15, binaryTree.search(15));
    }

    @Test
    void testSearchForAElementThatIsNotInTheTree(){
        binaryTree.add(1);
        binaryTree.add(2);
        assertEquals(0, binaryTree.search(20));
    }

    @Test
    void testEmptyTree() {
        assertTrue(binaryTree.isEmpty());
        assertEquals(0, binaryTree.search(10));
    }
}
