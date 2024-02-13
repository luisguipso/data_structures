package org.example.data_structures.tree;

public class BinaryTreePrinter {

    public static final String INVERTED_IN_ORDER = "inverted-in-order";
    public static final String POST_ORDER = "post-order";
    public static final String IN_ORDER = "in-order";
    public static final String PRE_ORDER = "pre-order";

    public static void print(BinaryTree tree) {
        if (tree.isEmpty()) {
            System.out.println("Empty tree.");
            return;
        }

        print(tree, PRE_ORDER);
    }
    public static void print(BinaryTree tree, String style){
        switch (style) {
            case PRE_ORDER: printPreOrder(tree); break;
            case IN_ORDER: printInOrder(tree); break;
            case POST_ORDER: printPostOrder(tree); break;
            case INVERTED_IN_ORDER: printInvertedInOrder(tree); break;
            default:
                throw new RuntimeException("Print method not found.");
        }
    }

    private static void printPreOrder(BinaryTree tree) {
        System.out.println(tree.getValue());
        if (tree.hasLeftElement())
            printPreOrder(tree.getLeft());
        if(tree.hasRightElement())
            printPreOrder(tree.getRight());
    }

    private static void printInOrder(BinaryTree tree){
        if(tree.hasLeftElement())
            printInOrder(tree.getLeft());

        System.out.println(tree.getValue());

        if(tree.hasRightElement())
            printInOrder(tree.getRight());
    }

    private static void printPostOrder(BinaryTree tree){
        if(tree.hasRightElement())
            printPostOrder(tree.getRight());
        
        if(tree.hasLeftElement())
            printPostOrder(tree.getLeft());

        System.out.println(tree.getValue());
    }

    private static void printInvertedInOrder(BinaryTree tree){
        if(tree.hasRightElement())
            printInvertedInOrder(tree.getRight());

        System.out.println(tree.getValue());
        
        if(tree.hasLeftElement())
            printInvertedInOrder(tree.getLeft());
    }
}
