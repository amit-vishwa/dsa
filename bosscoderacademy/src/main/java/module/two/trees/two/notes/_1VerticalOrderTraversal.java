package module.two.trees.two.notes;

import module.two.trees.Node;

import java.util.*;

/**
 * Vertical Order Traversal:
 * <p>
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree. For each node at position
 * (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively.
 * The root of the tree is at (0, 0). The vertical order traversal of a binary tree is a list of top-to-bottom orderings for
 * each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the
 * same row and same column. In such a case, sort the nodes by their values. Return the vertical order traversal of the
 * binary tree.
 * <p>
 * Example
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 */
public class _1VerticalOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println("Vertical Level Order Traversal: " + verticalLevelOrderTraversal(root));

        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Vertical Level Order Traversal: " + verticalLevelOrderTraversal(root));
    }

    /**
     * Approach:
     * - The approach is quite complex and can be solved sequentially.
     * - First create tree map that will store level and node data list.
     * - Also, create a queue which will store a pair of node and its vertical level.
     * - Start with the level order traversal loop using queue.
     * - Now, create a set that will store the pair of node data and its vertical level, ensure that it sorts pair by key.
     * - Pop the pair from queue and store its key node data and value in set.
     * - Now, check if pair key left and right exist, then add them in queue respectively.
     * - After completing that particular level, populate the map using set.
     * - Iterate over set and check if it's value (i.e. vertical order) exists in map.
     * - If yes, then simply add set value in map key's value, else create a list for map key's value and then add.
     * - Now after completing traversal using queue, just return the map values as list of list.
     * - Time complexity: Treemap takes O(N) + (Queue takes O(N) * for each queue data we have set that sorts O(logN)) + O(N) for list
     * i.e. O(N) + O(N*logN) + O(N) = O(2N) + O(N*logN) = O(N) + O(N*logN) = O(N*logN).
     * - Space complexity: O(N) as we are storing all nodes in list, map, queue and set.
     */
    private static ArrayList<ArrayList<Integer>> verticalLevelOrderTraversal(Node root) {
        TreeMap<Integer, ArrayList<Integer>> levelNodeDataListMap = new TreeMap<>();
        Queue<Pair<Node, Integer>> nodeLevelPairQueue = new LinkedList<>();
        nodeLevelPairQueue.offer(new Pair(root, 0));
        while (!nodeLevelPairQueue.isEmpty()) {
            TreeSet<Pair<Integer, Integer>> nodeDataLevelPairSet = new TreeSet<>(Comparator.comparing(pair -> pair.key));
            int queueSize = nodeLevelPairQueue.size();
            while (queueSize > 0) {
                Pair<Node, Integer> nodeLevelPair = nodeLevelPairQueue.poll();
                nodeDataLevelPairSet.add(new Pair(nodeLevelPair.key.data, nodeLevelPair.value));
                if (nodeLevelPair.key.left != null) {
                    nodeLevelPairQueue.offer(new Pair(nodeLevelPair.key.left, nodeLevelPair.value - 1));
                }
                if (nodeLevelPair.key.right != null) {
                    nodeLevelPairQueue.offer(new Pair(nodeLevelPair.key.right, nodeLevelPair.value + 1));
                }
                queueSize--;
            }
            for (Pair<Integer, Integer> nodeDataLevelPair : nodeDataLevelPairSet) {
                levelNodeDataListMap.computeIfAbsent(nodeDataLevelPair.value, nodeDataList -> new ArrayList<>()).add(nodeDataLevelPair.key);
            }
        }
        return new ArrayList<>(levelNodeDataListMap.values());
    }

}
