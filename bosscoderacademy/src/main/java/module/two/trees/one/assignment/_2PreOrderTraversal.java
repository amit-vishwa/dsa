package module.two.trees.one.assignment;

import java.util.ArrayList;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

// Refer _2PreOrderTraversal.java from package module.two.trees.notes.
public class _2PreOrderTraversal {

    public static void main(String[] args) {
        System.out.println(inOrderTraversal(BinaryTree.createDummyTree()));
    }

    private static ArrayList<Integer> inOrderTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.data);
        list.addAll(inOrderTraversal(root.left));
        list.addAll(inOrderTraversal(root.right));
        return list;
    }

}