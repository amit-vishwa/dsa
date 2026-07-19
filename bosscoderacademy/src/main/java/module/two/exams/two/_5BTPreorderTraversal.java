package module.two.exams.two;

import module.two.trees.Node;

import java.util.ArrayList;

// Refer _2PreOrderTraversal.java from package module.two.trees.notes.
public class _5BTPreorderTraversal {

    private static Node tree1() {
        Node node = new Node(1);
        node.right = new Node(2);
        node.right.left = new Node(3);
        return node;
    }

    private static Node tree2() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.right.left = new Node(6);
        node.left.right.right = new Node(7);
        node.right = new Node(3);
        node.right.right = new Node(8);
        node.right.right.left = new Node(9);
        return node;
    }

    public static void main(String[] args) {
        System.out.println("Preorder traversal of binary tree: " + binaryTreePreorderTraversal(tree1()));
        System.out.println("Preorder traversal of binary tree: " + binaryTreePreorderTraversal(tree2()));
        System.out.println("Preorder traversal of binary tree: " + binaryTreePreorderTraversal(null));
    }

    private static ArrayList<Integer> binaryTreePreorderTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> nodeDataList = new ArrayList<>();
        nodeDataList.add(root.data);
        nodeDataList.addAll(binaryTreePreorderTraversal(root.left));
        nodeDataList.addAll(binaryTreePreorderTraversal(root.right));
        return nodeDataList;
    }

}
