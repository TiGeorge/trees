package tree;

public class Tree {
    Node root;

    public Node find(int id) {
        Node current = root;
        while (current != null) {
            if (id == current.id) return current;
            if (id <= current.id) current = current.leftChild;
            else current = current.rightChild;
        }
        return null;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node(id, dd);
        if(root==null) {
            root = newNode;
            return;
        }
        Node current = root;
        while (true) {
            if (id <= current.id) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    return;
                } else current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    return;
                } else current = current.rightChild;
            }
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.print(node.id + " ");
            inOrder(node.rightChild);
        }
    }

    public Node minimum() {
        Node current = root;
        Node result = null;
        while (current != null) {
            result = current;
            current = current.leftChild;
        }
        return result;
    }

    private Node getSuccessor(Node node) {
        Node parent = node;
        Node successor = node.rightChild;
        while (successor.leftChild != null) {
            parent = successor;
            successor = successor.leftChild;
        }
        if (node.rightChild != successor) {
            parent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        } else {
            successor.leftChild = node.leftChild;
        }
        return successor;
    }

    public boolean delete(int id) {
        Node current = root;
        Node parent = root;
        boolean isLeftChaild = false;
        while (current.id != id) {
            parent = current;
            if (id < current.id) {
                current = current.leftChild;
                isLeftChaild = true;
            } else {
                current = current.rightChild;
                isLeftChaild = false;
            }
            if (current == null) return false;
        }
        if (current.leftChild == null && current.rightChild == null) {
            if(current == root) root = null;
            else if(isLeftChaild) parent.leftChild = null;
            else parent.rightChild = null;
        }

        if (current.rightChild == null) {
            if(current == root) root = current.leftChild;
            else if(isLeftChaild) parent.leftChild = current.leftChild;
            else parent.rightChild = current.leftChild;
        } else if (current.leftChild == null) {
            if (current == root) root = current.rightChild;
            else if (isLeftChaild) parent.leftChild = current.rightChild;
            else parent.rightChild = current.rightChild;
        } else {
            Node successor = getSuccessor(current);

            if (current == root) root = successor;
            else if (isLeftChaild) parent.leftChild = successor;
            else parent.rightChild = successor;
        }
        return true;
    }
}
/////////////////////////////////////////////////////////////////////

class Node {
    int id;
    double date;
    Node leftChild;
    Node rightChild;

    public Node(int id, double date) {
        this.id = id;
        this.date = date;
    }
}