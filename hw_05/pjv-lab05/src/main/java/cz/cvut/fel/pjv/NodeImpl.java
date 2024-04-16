package cz.cvut.fel.pjv;

public class NodeImpl implements Node{
    private final int key;
    Node left, right;
    public NodeImpl(int value){
        this.key = value;
        this.left = this.right = null;
    }

    @Override
    public Node getLeft() { return left; }

    @Override
    public Node getRight() {
        return right;
    }

    @Override
    public int getValue() {
        return key;
    }
}
