package module.two.bbst.assignment;

import java.util.*;

import module.two.bst.Node;

/**
 * All Nodes Distance K in Binary Tree:
 * <p>
 * Given a binary tree, a target node in the binary tree, and an integer value k, find all the nodes that are at distance k
 * from the given target node. No parent pointers are available.
 * Note: You have to return list in sorted order.
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [1,4,7]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * <p>
 * Input: root = [1], target = 1, k = 3
 * Output: []
 * <p>
 * Constraints:
 * 1 ≤ N ≤ 103
 * 1 ≤ data of node ≤ 104
 * 1 ≤ target ≤ 104
 * 1 ≤ k ≤ 20
 */
public class _7KDistanceBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right = new Node(1);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        System.out.println("Nodes at K distance from target node: " + Arrays.toString(kDistanceNodes(root, 5, 2)));

        root = new Node(1);
        System.out.println("Nodes at K distance from target node: " + Arrays.toString(kDistanceNodes(root, 1, 3)));
    }

    /**
     * Approach:
     * - The approach here is not much straightforward.
     * - We have to first create a parent map for all nodes along with the target node.
     * - Then add target node in queue and mark is as visited.
     * - Now, do the simple level order traversal using queue and for each level insert nodes in queue and mark visited.
     * - Only non-visited nodes must be inserted in the queue.
     * - First insert left node if not null, then insert right node if not null, also the insert parent node.
     * - After traversing level order, check if queue is empty.
     * - If empty, just return empty array, else add node values in the list and sort it and return it as array.
     * - Time complexity: O(N) as nodes are visited multiple fixed amount of times.
     * - Space complexity: O(N) due to queue, set, map and list.
     */
    private static int[] kDistanceNodes(Node root, int target, int k) {
        if (root == null) {
            return new int[0];
        }
        HashMap<Node, Node> parentMap = new HashMap<>();
        Node targetNode = populateParentMap(parentMap, root, target);
        if (targetNode == null) {
            return new int[0];
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> seen = new HashSet<>();
        queue.offer(targetNode);
        seen.add(targetNode);
        while (!queue.isEmpty()) {
            if (k == 0) {
                break;
            }
            int size = queue.size();
            while (size > 0) {
                Node current = queue.poll();
                if (current.left != null && !seen.contains(current.left)) {
                    seen.add(current.left);
                    queue.offer(current.left);
                }
                if (current.right != null && !seen.contains(current.right)) {
                    seen.add(current.right);
                    queue.offer(current.right);
                }
                if (parentMap.containsKey(current) && !seen.contains(parentMap.get(current))) {
                    seen.add(parentMap.get(current));
                    queue.offer(parentMap.get(current));
                }
                size--;
            }
            k--;
        }
        if (queue.isEmpty()) {
            return new int[0];
        }
        ArrayList<Integer> kDistanceNodeList = new ArrayList<>();
        while (!queue.isEmpty()) {
            kDistanceNodeList.add(queue.poll().data);
        }
        return kDistanceNodeList.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private static Node populateParentMap(HashMap<Node, Node> parentMap, Node root, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node targetNode = null;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == target) {
                targetNode = current;
            }
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }
        return targetNode;
    }

}