package module.two.trees.one.assignment;

import java.util.ArrayList;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

// Refer _1InOrderTraversal.java from package module.two.trees.notes.
public class _1InOrderTraversal {

    public static void main(String[] args) {
        System.out.println(inOrderTraversal(BinaryTree.createDummyTree()));
    }

    private static ArrayList<Integer> inOrderTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(inOrderTraversal(root.left));
        list.add(root.data);
        list.addAll(inOrderTraversal(root.right));
        return list;
    }

}