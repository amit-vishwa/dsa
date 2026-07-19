package module.two.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public Node root;

    public BinaryTree() {
        this.root = new Node();
    }

    public BinaryTree(Node node) {
        this.root = node;
    }

    public static Node createDummyTree() {
        Node node = new Node(10);

        node.left = new Node(5);
        node.left.left = new Node(4);
        node.left.right = new Node(6);

        node.right = new Node(15);
        node.right.left = new Node(14);
        node.right.right = new Node(16);

        return node;
    }

    public static void display(Node root, int traversal) {
        if (traversal == 1) {
            preOrderTraversal(root);
        } else if (traversal == 2) {
            inOrderTraversal(root);
        } else if (traversal == 3) {
            postOrderTraversal(root);
        } else {
            levelOrderTraversal(root);
        }
        System.out.println("null");
    }

    private static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " -> ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " -> ");
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " -> ");
    }

    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " -> ");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

}
