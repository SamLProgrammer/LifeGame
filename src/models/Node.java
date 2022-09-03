package models;

public class Node {
    private Node leftNode;
    private Node rightNode;
    private int value;

    public Node (int value ) {
        this.value = value;
    }

    public boolean hasTwins() {
        return rightNode != null && leftNode != null;
    }

    public boolean isLeaf() {
        return rightNode == null && leftNode == null;
    }








    public Node getRightNode() {
        return rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
