package module.one.recursion.two.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * All Permutation of given Array:
 * <p>
 * Given an array arr of distinct integers, print all permutations of Array.
 * <p>
 * Example
 * Input: n=3, arr = [1, 2, 3]
 * Output: [ [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1] ]
 */
public class _1ArrayPermutations {

    public static void main(String[] args) {
        printPermutations(new int[]{1, 2, 3}, 3);
        printPermutations(new int[]{1, 1, 2, 3}, 4);
    }

    private static void printPermutations(int[] arr, int n) {
        System.out.println("All array permutations by approach 1: " + approach1(arr, n));
        System.out.println("All array permutations by approach 2: " + approach2(arr, n));
        System.out.println("All array permutations by approach 3: " + approach3(arr, n));
        System.out.println();
    }

    /**
     * Approach 1:
     * - This is a simple approach, where we are finding the permutations of given array with distinct elements.
     * - The logic is simple, it checks all the indexes and calculates permutations for them.
     * - If add the element in permutation list if it not exists in it, then it explores further permutation with next
     * index and then it backtracks.
     * - At last when permutation size is equal to array length then we got our permutation.
     * - Time complexity: O(N) for iterating on array * O(N) for contains method * O(N!) to calculate permutation = O(N*N*N!)
     * - Space complexity: O(N + 1) for recursion stack i.e. loop from 0 to N = O(N) auxiliary space, rest list will take O(N*N!) space.
     */
    private static List<List<Integer>> approach1(int[] arr, int n) {
        return helper1(arr, n, new ArrayList<>());
    }

    private static List<List<Integer>> helper1(int[] arr, int n, List<Integer> permutation) {
        if (permutation.size() == n) {
            return new ArrayList<>(List.of(new ArrayList<>(permutation)));
        }
        List<List<Integer>> permutationList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!permutation.contains(arr[i])) {
                permutation.add(arr[i]);
                permutationList.addAll(helper1(arr, n, permutation));
                permutation.removeLast();
            }
        }
        return permutationList;
    }

    /**
     * Approach 2:
     * - It is modified version of approach 1.
     * - Here, we are also checking for duplicates elements are finding the distinct permutation.
     * - We are using boolean array to track visited elements.
     * - When current element is visited or current and previous are same and previous is not visited then skip the
     * permutation for that element.
     * - We will always check permutation for distinct element, we will also backtrack for other elements.
     * - When permutation size is equal to array length then we got our permutation, we add that to result list.
     * - Time complexity: O(N) for loop * O(N!) for permutations = O(N*N!)
     * - Space complexity: O(N) for recursion stack + O(N) for boolean array, O(N*N!) for result list
     */
    private static List<List<Integer>> approach2(int[] arr, int n) {
        Arrays.sort(arr);
        return helper2(arr, n, new ArrayList<>(), new boolean[n]);
    }

    private static List<List<Integer>> helper2(int[] arr, int n, List<Integer> permutation, boolean[] visited) {
        if (permutation.size() == n) {
            return new ArrayList<>(List.of(new ArrayList<>(permutation)));
        }
        List<List<Integer>> permutationList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] || (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            permutation.add(arr[i]);
            permutationList.addAll(helper2(arr, n, permutation, visited));
            permutation.removeLast();
            visited[i] = false;
        }
        return permutationList;
    }

    /**
     * Approach 3:
     * - The approach is different from above approaches.
     * - We are iterating over the array and also have an index to track.
     * - We are swapping the current index and tracking index to calculate the permutation.
     * - When our tracked index is equal to array length, then we got our permutation.
     * - Time complexity: O(N) for loop * O(N!) for permutation = O(N*N!)
     * - Space complexity: O(N) for recursion stack
     */
    private static List<List<Integer>> approach3(int[] arr, int n) {
        return helper3(arr, n, 0);
    }

    private static List<List<Integer>> helper3(int[] arr, int n, int index) {
        if (index == arr.length) {
            return new ArrayList<>(List.of(Arrays.stream(arr).boxed().toList()));
        }
        List<List<Integer>> permutations = new ArrayList<>();
        for (int i = index; i < n; i++) {
            swap(arr, i, index);
            permutations.addAll(helper3(arr, n, index + 1));
            swap(arr, i, index);
        }
        return permutations;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
