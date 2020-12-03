package hw6;


import javax.swing.*;

public class task2 {
    /*
    Задание 6.2
        Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
     */
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(2, "привет");
        tree.insert(new Node<String>(1, "aloha"));

        tree.print();
    }

}

class Node<T> {
    public int key;
    public T data;
    public Node leftChild;
    public Node rightChild;

    public Node() {
    }

    public Node(int key, T data) {
        this.key = key;
        this.data = data;
    }

    public void print() {
        System.out.println("key: " + key + " data: " + data.toString());
    }
}

class Tree {
    private Node root;

    public Node find(int key) {
        Node current = root;
        while (current.key != key) {
            if (current.key < key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node rootNode) {
        if (rootNode != null) {
            rootNode.print();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.print();
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            rootNode.print();
            postOrder(rootNode.rightChild);
        }
    }

    public Node min() {
        return min(root);
    }

    public Node min(Node cur) {
        Node last = null;
        while (cur != null) {
            last = cur;
            cur = cur.leftChild;
        }
        return last;
    }

    public Node max() {
        return max(root);
    }

    public Node max(Node cur) {
        Node last = null;
        while (cur != null) {
            last = cur;
            cur = cur.rightChild;
        }
        return last;
    }

    public void insert(int key, Object data) {
        Node node = new Node();
        node.key = key;
        node.data = data;
        insert(node);
    }

    public void insert(Node node) {
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node prev = null;
            while (true) {
                prev = current;
                if (node.key < prev.key) {
                    current = current.leftChild;
                    if (current == null) {
                        prev.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        prev.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.key != key) {
            parent = current;
            if (key < current.key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {

                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == null) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {

                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccesor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;

            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    Node getSuccesor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    public void print() {
        print(root);
    }

    public void print(Node startNode) {
        if (startNode != null) {
            print(startNode.leftChild);
            startNode.print();
            print(startNode.rightChild);
        }
    }
}