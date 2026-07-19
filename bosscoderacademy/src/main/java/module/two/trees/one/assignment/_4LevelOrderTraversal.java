package module.two.trees.one.assignment;

import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

// Refer _4LevelOrderTraversal.java from package module.two.trees.notes.
public class _4LevelOrderTraversal {

    public static void main(String[] args) {
        System.out.println("Level order traversal: " + Arrays.toString(levelOrderTraversal(BinaryTree.createDummyTree())));
    }

    private static int[] levelOrderTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            list.add(temp.data);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}