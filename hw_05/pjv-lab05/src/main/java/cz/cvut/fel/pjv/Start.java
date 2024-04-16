package cz.cvut.fel.pjv;

public class Start {
    public static void main(String[] args) {

        TreeImpl tree = new TreeImpl();
        tree.setTree(new int [] {44, 5, 8, 7, 32, 23, 3, 6, 9, 10, 222, 34, 1, 33, 66});
        System.out.println(tree.toString());
        System.out.println("___________________");

        tree.setTree(new int [] {1,2,3,4,5,6,7,8});
        System.out.println(tree.toString());
        System.out.println("___________________");

        tree.setTree(new int [] {8,123,321,55342,12,331});
        System.out.println(tree.toString());
        System.out.println("___________________");

    }
}
