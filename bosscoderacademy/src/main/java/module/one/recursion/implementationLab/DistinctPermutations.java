package module.one.recursion.implementationLab;

import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Find all permutations of distinct array: [Leetcode 46. Permutations]
 * <p>
 * Given an array with distinct elements, find all the distinct permutations.
 * We have multiple approaches to find all permutations.
 * The total permutation count is array length factorial.
 */
public class DistinctPermutations {

    private static final List<List<Integer>> PERMUTATIONS = new ArrayList<>();

    public static void main(String[] args) {
        printPermutations(new int[]{1, 2, 3});
    }

    private static void printPermutations(int[] arr) {
        approach1(arr, new ArrayList<Integer>());
        System.out.println("Permutations by approach 1: " + DistinctPermutations.PERMUTATIONS);
        System.out.println("Permutations by approach 2: " + approach2(arr, new ArrayList<Integer>()));
        System.out.println("Permutations by approach 3: " + approach3(arr, new ArrayList<Integer>()));
        System.out.println("Permutations by approach 4: " + approach4(arr, new LinkedHashSet<Integer>()));
        System.out.println();
    }

    /**
     * Approach 1:
     * - The approach is simple, we are calculating all the permutations.
     * - Here, we are using global array list where we are adding all the permutations.
     * - Time complexity: O(N) for looping array * O(N) due to array list contains method * O(N!) due to recursion call
     * = O(N) * O(N) * O(N!) = O(N*N*N!) = O(N^2 * N!)
     * - Space complexity: O(N+1) for recursion stack tree auxiliary space + O(N!) for arraylist
     * = total auxiliary space is O(N).
     */
    private static void approach1(int[] arr, List<Integer> used) {
        if (arr.length == used.size()) {
            DistinctPermutations.PERMUTATIONS.add(new ArrayList<>(used));
            return;
        }
        for (int num : arr) { // O(N)
            if (!used.contains(num)) { // O(N)
                used.add(num);
                approach1(arr, used); // O(N!)
                used.removeLast();
            }
        }
    }

    /**
     * Approach 2:
     * - The approach is similar to approach 1 only.
     * - Here, we are using list inside the method and returning that list, rest all are same.
     * - Time complexity: O(N) for looping array * O(N) due to array list contains method * O(N!) due to recursion call
     * = O(N) * O(N) * O(N!) = O(N*N*N!) = O(N^2 * N!)
     * - Space complexity: O(N+1) for recursion stack tree auxiliary space + O(N!) for arraylist
     * = total auxiliary space is O(N).
     */
    private static ArrayList<ArrayList<Integer>> approach2(int[] arr, ArrayList<Integer> used) {
        if (used.size() == arr.length) {
            return new ArrayList<ArrayList<Integer>>(List.of(new ArrayList<Integer>(used)));
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!used.contains(arr[i])) {
                used.add(arr[i]);
                list.addAll(approach2(arr, used));
                used.remove(Integer.valueOf(arr[i]));
            }
        }
        return list;
    }

    /**
     * Approach 3:
     * - The approach is similar to approach 2.
     * - Here, we are using list to leverage the remove last method.
     * - Time complexity: O(N) for looping array * O(N) due to array list contains method * O(N!) due to recursion call
     * = O(N) * O(N) * O(N!) = O(N*N*N!) = O(N^2 * N!)
     * - Space complexity: O(N+1) for recursion stack tree auxiliary space + O(N!) for arraylist
     * = total auxiliary space is O(N).
     */
    private static List<List<Integer>> approach3(int[] arr, ArrayList<Integer> used) {
        if (used.size() == arr.length) {
            return new ArrayList<List<Integer>>(List.of(new ArrayList<Integer>(used)));
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!used.contains(arr[i])) {
                used.add(arr[i]);
                list.addAll(approach3(arr, used));
                used.removeLast();
            }
        }
        return list;
    }

    /**
     * Approach 4:
     * - The approach is similar to approach 2.
     * - Here, we are using linked hashset to optimize the contains method in O(1) time.
     * - Time complexity: O(N) for looping array * O(1) for contains method * O(N!) due to recursion call
     * = O(N) * O(1) * O(N!) = O(N*1*N!) = O(N * N!)
     * - Space complexity: O(N+1) for recursion stack tree auxiliary space + O(N!) for arraylist
     * = total auxiliary space is O(N).
     */
    private static List<List<Integer>> approach4(int[] arr, LinkedHashSet<Integer> used) {
        if (used.size() == arr.length) {
            return new ArrayList<List<Integer>>(List.of(new ArrayList<>(used)));
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int num : arr) {
            if (!used.contains(num)) {
                used.add(num);
                lists.addAll(approach4(arr, used));
                used.remove(num);
            }
        }
        return lists;
    }

}
