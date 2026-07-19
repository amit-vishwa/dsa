package module.two.bbst.lecture;

import module.two.bst.BinaryTree;
import module.two.bst.Node;

import java.util.ArrayList;

// Refer _4MergeBSTs.java from package module.two.bst.assignment.
public class _3ConcatenateTrees {

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        Node root2 = new Node(1);
        root2.left = new Node(0);
        root2.right = new Node(3);
        BinaryTree.display(mergeTrees(root1, root2), 2);
    }

    private static Node mergeTrees(Node root1, Node root2) {
        ArrayList<Integer> list1 = nodeList(root1);
        ArrayList<Integer> list2 = nodeList(root2);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            list.add(list1.get(i) <= list2.get(j) ? list1.get(i++) : list2.get(j++));
        }
        while (i < list1.size()) {
            list.add(list1.get(i++));
        }
        while (j < list2.size()) {
            list.add(list2.get(j++));
        }
        return buildTree(list, 0, list.size() - 1);
    }

    private static Node buildTree(ArrayList<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start + 1) / 2; // to pick second mid for even length
        Node root = new Node(list.get(mid));
        root.left = buildTree(list, start, mid - 1);
        root.right = buildTree(list, mid + 1, end);
        return root;
    }

    private static ArrayList<Integer> nodeList(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = nodeList(root.left);
        list.add(root.data);
        list.addAll(nodeList(root.right));
        return list;
    }

}
