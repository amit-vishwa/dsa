package module.two.exams.milestone;

import module.two.trees.Node;

import java.util.ArrayList;

// Refer _3PostOrderTraversal.java from package module.two.trees.notes.
public class _7PostOrderTraversal {

    private static Node tree1() {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(3);
        return root;
    }

    private static Node tree2() {
        return new Node(1);
    }

    public static void main(String[] args) {
        System.out.println("Pre order traversal of Binary tree: " + preOrderTraversal(tree1()));
        System.out.println("Pre order traversal of Binary tree: " + preOrderTraversal(tree2()));
    }

    private static ArrayList<Integer> preOrderTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> nodeList = preOrderTraversal(root.left);
        nodeList.addAll(preOrderTraversal(root.right));
        nodeList.add(root.data);
        return nodeList;
    }

}
