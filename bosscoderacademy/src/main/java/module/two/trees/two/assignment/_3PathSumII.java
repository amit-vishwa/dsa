package module.two.trees.two.assignment;

import module.two.trees.Node;

import java.util.ArrayList;

// Refer _4PathSumI.java from package module.two.trees.two.notes.
public class _3PathSumII {

    private static Node tree1() {
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right = new Node(8);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);
        return root;
    }

    private static Node tree2() {
        Node root = new Node(1);
        root.left = new Node(20);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(15);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
        root.right.right.left.left = new Node(8);
        root.right.right.left.right = new Node(9);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Path sum list: " + pathSumList(tree1(), 22));
        System.out.println("Path sum list: " + pathSumList(tree2(), 8));
    }

    private static ArrayList<ArrayList<Integer>> pathSumList(Node root, int sum) {
        return helper(root, sum, new ArrayList<>());
    }

    private static ArrayList<ArrayList<Integer>> helper(Node root, int sum, ArrayList<Integer> path) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        if (root.left == null && root.right == null) {
            path.add(root.data);
            sum -= root.data;
            if (sum == 0) {
                pathList.add(new ArrayList<>(path));
            }
            path.removeLast();
            return pathList;
        }
        path.add(root.data);
        sum -= root.data;
        pathList.addAll(helper(root.left, sum, path));
        pathList.addAll(helper(root.right, sum, path));
        path.removeLast();
        return pathList;
    }

}