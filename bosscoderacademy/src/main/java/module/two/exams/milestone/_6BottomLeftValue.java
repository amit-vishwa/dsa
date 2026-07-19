package module.two.exams.milestone;

import module.two.trees.Node;

import java.util.LinkedList;
import java.util.Queue;

// Refer: _3BottomLeftValue.java from package module.two.bbst.assignment.
public class _6BottomLeftValue {

    private static Node tree1() {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        return root;
    }

    private static Node tree2() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Leftmost value at the last row: " + bottomLeftValue(tree1()));
        System.out.println("Leftmost value at the last row: " + bottomLeftValue(tree2()));
    }

    private static int bottomLeftValue(Node root) {
        if (root == null) {
            return -1;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int bottomLeftValue = root.data;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i == 0) {
                    bottomLeftValue = node.data;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return bottomLeftValue;
    }
}
