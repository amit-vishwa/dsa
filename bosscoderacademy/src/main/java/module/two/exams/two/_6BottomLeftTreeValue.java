package module.two.exams.two;

import module.two.trees.Node;

import java.util.LinkedList;
import java.util.Queue;

// Refer _3BottomLeftValue.java from package module.two.bbst.assignment.
public class _6BottomLeftTreeValue {

    private static Node tree1() {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);
        return node;
    }

    private static Node tree2() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.right = new Node(3);
        node.right.left = new Node(5);
        node.right.right = new Node(6);
        node.right.left.left = new Node(7);
        return node;
    }

    public static void main(String[] args) {
        System.out.println("Bottom left value of binary tree: " + bottomLeftValue(tree1()));
        System.out.println("Bottom left value of binary tree: " + bottomLeftValue(tree2()));
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
