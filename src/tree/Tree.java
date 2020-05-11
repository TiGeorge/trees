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

    public void delete(int id) {

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