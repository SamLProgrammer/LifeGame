package models;

public class Tree {

    private Node headNode;

    public Tree(Node headNode) {
        this.headNode = headNode;
    }

    public Tree() {
        initExampleTree();
    }

    private void initExampleTree() {

        for(int i = 0; i < 10; i++) {
            addNode(new Node((int)(Math.random()*100)));
        }
/*        addNode(new Node(10));
        addNode(new Node(13));
        addNode(new Node(16));
        addNode(new Node(20));*/
        /*addNode(new Node(6));
        addNode(new Node(3));
        addNode(new Node(8));
        addNode(new Node(9));
        addNode(new Node(7));
        addNode(new Node(5));
        addNode(new Node(2));
        addNode(new Node(9));*/
    }

    public void belowBalanceTree(Node node) {
        if(node != null) {
            if (!node.isLeaf()) {
                belowBalanceTree(node.getLeftNode());
                belowBalanceTree(node.getRightNode());
            }
            balanceSubTree(node);
        }
    }

    private void balanceSubTree(Node node) {
        int nodeBalance = checkNodeBalance(node);
        if(Math.abs(nodeBalance) > 1) {
            if(nodeBalance > 0) {

            } else {

            }
        }
    }

    public int checkNodeBalance(Node node) {
        return (node.hasTwins()) ? belowCountLevels(headNode.getLeftNode()) - belowCountLevels(headNode.getRightNode()) :
                (node.getRightNode() != null) ? -1*belowCountLevels(headNode.getRightNode()) :
                        belowCountLevels(headNode.getLeftNode());
    }



    public Node addNode(Node node) {
        return (headNode != null) ? belowAddNode(headNode, node) : (headNode = node);
    }

    public Node belowAddNode(Node currentNode, Node toAddNode) {
        if(toAddNode.getValue() > currentNode.getValue()) {
            if(currentNode.getRightNode() != null) {
                return belowAddNode(currentNode.getRightNode(), toAddNode);
            } else {
                currentNode.setRightNode(toAddNode);
                return toAddNode;
            }
        } else if(toAddNode.getValue() < currentNode.getValue()){
            if(currentNode.getLeftNode() != null) {
                return belowAddNode(currentNode.getLeftNode(), toAddNode);
            } else {
                currentNode.setLeftNode(toAddNode);
                return toAddNode;
            }
        } else {
            return null;
        }
    }

    public int countLevels() {
        return (headNode == null) ? 0 : belowCountLevels(headNode);
    }

    private int belowCountLevels(Node currentNode) {
        if(!currentNode.isLeaf()) {
            if(currentNode.hasTwins()) {
                int rightCount = belowCountLevels(currentNode.getRightNode());
                int leftCount = belowCountLevels(currentNode.getLeftNode());
                return (leftCount < rightCount) ? 1 + rightCount : 1 + leftCount;
            } else if (currentNode.getLeftNode() == null) {
                return 1 + belowCountLevels(currentNode.getRightNode());
            } else {
                return 1 + belowCountLevels(currentNode.getLeftNode());
            }
        }else {
            return 1;
        }
    }

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }
}
