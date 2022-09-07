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

/*        for(int i = 0; i < 10; i++) {
            addNode(new Node((int)(Math.random()*100)));
        }*/
/*        Node node20 = new Node(20);
        Node node16 = new Node(16);
        Node node13 = new Node(13);
        Node node15 = new Node(15);
        Node node4 = new Node(4);
        Node node8 = new Node(8);
        Node node10 = new Node(10);
        addNode(node10);
        addNode(node16);
        addNode(node13);
        addNode(node20);
        addNode(new Node(6));
        addNode(new Node(3));
        addNode(node8);
        addNode(new Node(9));
        addNode(new Node(7));
        addNode(new Node(5));
        addNode(new Node(2));
        addNode(node15);
        addNode(node4);*/
    }

    private Node belowFatherNode(Node currentNode, Node childNode) {
        if(currentNode.getRightNode() == childNode || currentNode.getLeftNode() == childNode) {
            return currentNode;
        } else {
            if(currentNode.isLeaf()) {
                return null;
            } else {
                if(currentNode.hasTwins()) {
                    Node resultingNodeByLeft = belowFatherNode(currentNode.getLeftNode(), childNode);
                    Node resultingNodeByRight = belowFatherNode(currentNode.getRightNode(), childNode);
                    return (resultingNodeByLeft == null && resultingNodeByRight == null) ? null : (resultingNodeByRight != null) ? resultingNodeByRight : resultingNodeByLeft;
                } else if(currentNode.getRightNode() != null){
                    return belowFatherNode(currentNode.getRightNode(), childNode);
                } else {
                    return belowFatherNode(currentNode.getLeftNode(), childNode);
                }
            }
        }
    }

    public Node nodeExists(Node node) { //Perfectly Working
        return (headNode == null) ? null : belowNodeExists(headNode, node);
    }

    private Node belowNodeExists(Node node, Node testNode) {
        if(node == testNode) {
            return node;
        } else {
            if(node.isLeaf()) {
                return null;
            } else {
                if(node.hasTwins()) {
                    Node resultingNodeByLeft = belowNodeExists(node.getLeftNode(), testNode);
                    Node resultingNodeByRight = belowNodeExists(node.getRightNode(), testNode);
                    return (resultingNodeByLeft == null && resultingNodeByRight == null) ? null: (resultingNodeByLeft != null) ? resultingNodeByLeft : resultingNodeByRight ;
                } else if(node.getRightNode() != null){
                    return belowNodeExists(node.getRightNode(), testNode);
                } else {
                    return belowNodeExists(node.getLeftNode(), testNode);
                }
            }
        }
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
                if(node.getRightNode().getLeftNode() == null) {

                }
            } else {

            }
        }
    }

    public int checkNodeBalance(Node node) {
        return (node.hasTwins()) ? belowCountLevels(headNode.getLeftNode()) - belowCountLevels(headNode.getRightNode()) :
                (node.getRightNode() != null) ? -1*belowCountLevels(headNode.getRightNode()) :
                        belowCountLevels(headNode.getLeftNode());
    }



    public Node addNode(Node node) { //Perfectly Working
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

    public int countLevels() { //Perfectly Working
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
