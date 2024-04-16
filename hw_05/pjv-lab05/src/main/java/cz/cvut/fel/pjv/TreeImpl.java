package cz.cvut.fel.pjv;
import java.util.Arrays;

public class TreeImpl implements Tree{
    private Node root;

    public TreeImpl(){
        this.root = null;
    }
    @Override
    public void setTree(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }

        int[] uniqueValues = removeDuplicates(values);
        //arrayToBinaryTree(root, values, 0);
        root = arrayToBinaryTree(uniqueValues,0, uniqueValues.length - 1);
    }
    private int[] removeDuplicates(int[] values) {
        int j = 0;
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] != values[i + 1]) {
                values[j++] = values[i];
            }
        }
        values[j++] = values[values.length - 1];
        int[] uniqueVal = new int[j];
        System.arraycopy(values, 0, uniqueVal, 0, j);
        return uniqueVal;
    }

    private Node arrayToBinaryTree(int[]values, int startIndex, int endIndex) {
        if(startIndex>endIndex){
            return null;
        }
        int midIndex = (startIndex+endIndex)/2;
        if ((startIndex + endIndex) % 2 != 0) {
            midIndex++;
        }
        NodeImpl node = new NodeImpl(values[midIndex]);

        node.left = arrayToBinaryTree(values, startIndex, midIndex-1);
        node.right = arrayToBinaryTree(values, midIndex+1, endIndex);

        return node;
    }


    @Override
    public Node getRoot() {
        return root;
    }
    @Override
    public String toString() {
        return toStringRecursion(root, 0);
    }

    private String toStringRecursion(Node node, int heigth) {

        if (node == null) {
            return "";
        }
        String result = "";
        for (int i = 0; i < heigth; i++) {
            result += " ";
        }
        result += "- " + node.getValue() + "\n";
        result += toStringRecursion(node.getLeft(), heigth + 1);
        result += toStringRecursion(node.getRight(), heigth + 1);
        return result;
    }
}
