package cz.cvut.fel.pjv;
import static org.junit.Assert.*;
import org.junit.Test;

public class TreeImplTest {

    @Test
    public void testSetTree() {
        Tree tree = new TreeImpl();
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        tree.setTree(values);
        assertEquals(5, tree.getRoot().getValue()); // Root should be 5
        assertEquals(3, tree.getRoot().getLeft().getValue()); // Left child of root should be 3
        assertEquals(7, tree.getRoot().getRight().getValue()); // Right child of root should be 7
        assertEquals(2, tree.getRoot().getLeft().getLeft().getValue()); // Left child of 3 should be 2
        assertEquals(4, tree.getRoot().getLeft().getRight().getValue()); // Right child of 3 should be 4
        assertEquals(6, tree.getRoot().getRight().getLeft().getValue()); // Left child of 7 should be 6
        assertEquals(8, tree.getRoot().getRight().getRight().getValue()); // Right child of 7 should be 8
    }

    @Test
    public void testToString() {
        Tree tree = new TreeImpl();
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        tree.setTree(values);
        String expected = "- 5\n" +
                " - 3\n" +
                "  - 2\n" +
                "  - 4\n" +
                " - 7\n" +
                "  - 6\n" +
                "  - 8\n";
        assertEquals(expected, tree.toString());
    }

    @Test
    public void testEmptyTree() {
        Tree tree = new TreeImpl();
        int[] values = {};
        tree.setTree(values);
        assertNull(tree.getRoot()); // Root should be null for empty tree
    }

    @Test
    public void testSingleElementTree() {
        Tree tree = new TreeImpl();
        int[] values = {5};
        tree.setTree(values);
        assertEquals(5, tree.getRoot().getValue()); // Root should be 5 for single element tree
        assertNull(tree.getRoot().getLeft()); // Left child should be null
        assertNull(tree.getRoot().getRight()); // Right child should be null
    }

    @Test
    public void testDuplicateValues() {
        Tree tree = new TreeImpl();
        int[] values = {5, 3, 7, 3, 2, 5};
        tree.setTree(values);
        assertEquals(5, tree.getRoot().getValue()); // Root should be 5
        assertEquals(3, tree.getRoot().getLeft().getValue()); // Left child of root should be 3
        assertEquals(2, tree.getRoot().getLeft().getLeft().getValue()); // Left child of 3 should be 2
        assertNull(tree.getRoot().getLeft().getRight()); // Right child of 3 should be null
        assertEquals(7, tree.getRoot().getRight().getValue()); // Right child of root should be 7
        assertNull(tree.getRoot().getRight().getLeft()); // Left child of 7 should be null
        assertNull(tree.getRoot().getRight().getRight()); // Right child of 7 should be null
    }

    @Test
    public void testSetTreeWithLargeData() {
        Tree tree = new TreeImpl();
        int[] values = generateLargeInputArray(1000); // Generating a large input array
        tree.setTree(values);
        // Verify the BST properties
        assertTrue(isBST(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testSetTreeWithRandomData() {
        Tree tree = new TreeImpl();
        // Generate random input array
        int[] values = generateRandomInputArray(100);
        tree.setTree(values);
        System.out.println(tree.toString());
        // Verify the BST properties
        assertTrue(isBST(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testSetTreeWithEmptyArray() {
        Tree tree = new TreeImpl();
        int[] values = {};
        tree.setTree(values);
        assertNull(tree.getRoot()); // Root should be null for an empty tree
    }

    @Test
    public void testSetTreeWithSingleElement() {
        Tree tree = new TreeImpl();
        int[] values = {5};
        tree.setTree(values);
        assertEquals(5, tree.getRoot().getValue()); // Root should be 5 for single element tree
        assertNull(tree.getRoot().getLeft()); // Left child should be null
        assertNull(tree.getRoot().getRight()); // Right child should be null
    }

    @Test
    public void testSetTreeWithDuplicateValues() {
        Tree tree = new TreeImpl();
        int[] values = {5, 3, 7, 3, 2, 5};
        tree.setTree(values);
        // Verify the BST properties
        assertTrue(isBST(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    // Helper method to generate a large input array
    private int[] generateLargeInputArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // Helper method to generate a random input array
    private int[] generateRandomInputArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000); // Generate random numbers between 0 and 999
        }
        return array;
    }

    // Helper method to check if a binary tree is a binary search tree
    private boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.getValue() <= min || node.getValue() >= max) {
            return false;
        }
        return isBST(node.getLeft(), min, node.getValue()) && isBST(node.getRight(), node.getValue(), max);
    }
}
