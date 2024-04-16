package cz.cvut.fel.pjv;

public class TreeTest {
    public static void main(String[] args) {
        int[][] sequences = {
                {1},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3, 4},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7, 8},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        for (int[] sequence : sequences) {
            Tree tree = new TreeImpl();
            tree.setTree(sequence);
            System.out.println("Sequence: " + java.util.Arrays.toString(sequence));
            System.out.println(tree);
            System.out.println();
        }
    }
}
