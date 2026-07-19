package module.two.bst.lecture;

import module.two.bst.BinaryTree;
import module.two.bst.Node;

import java.util.ArrayList;
import java.util.Arrays;

// Refer: https://www.geeksforgeeks.org/problems/merge-two-bst-s/1
public class _4MergeTwoBSTs {

    public static void main(String[] args) {
        Node node1 = new Node(3);
        node1.left = new Node(1);
        node1.right = new Node(5);
        Node node2 = new Node(4);
        node2.left = new Node(2);
        node2.right = new Node(6);
        BinaryTree.display(mergeBSTs(node1, node2), 2);
    }

    private static Node mergeBSTs(Node root1, Node root2) {
        int[] arr1 = treeToArray(root1).stream().mapToInt(Integer::intValue).toArray();
        int[] arr2 = treeToArray(root2).stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Array1: " + Arrays.toString(arr1));
        System.out.println("Array2: " + Arrays.toString(arr2));
        int[] sortedArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            sortedArray[k++] = (arr1[i] <= arr2[j]) ? arr1[i++] : arr2[j++];
        }
        while (i < arr1.length) {
            sortedArray[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            sortedArray[k++] = arr2[j++];
        }
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        return binarySearchTree(sortedArray, 0, sortedArray.length - 1);
    }

    private static Node binarySearchTree(int[] arr, int s, int e) {
        if (s > e) {
            return null;
        }
        int m = s + (e - s) / 2;
        Node root = new Node(arr[m]);
        root.left = binarySearchTree(arr, s, m - 1);
        root.right = binarySearchTree(arr, m + 1, e);
        return root;
    }

    private static ArrayList<Integer> treeToArray(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = treeToArray(root.left);
        list.add(root.data);
        list.addAll(treeToArray(root.right));
        return list;
    }

}
