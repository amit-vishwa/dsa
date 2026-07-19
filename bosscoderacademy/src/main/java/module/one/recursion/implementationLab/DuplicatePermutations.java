package module.one.recursion.implementationLab;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Duplicate array elements distinct permutations:
 * <p>
 * Given an array with duplicate elements, return the permutation list with distinct permutations.
 * The logic is simple, just skip calculating duplicate permutations.
 */
public class DuplicatePermutations {

    public static void main(String[] args) {
        printPermutations(new int[]{1, 2, 1});
        printPermutations(new int[]{1, 2, 3});
        printPermutations(new int[]{1, 1, 0, 0});
    }

    private static void printPermutations(int[] arr) {
        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println("Distinct permutations by approach 1: " + approach1(arr, new boolean[arr.length], new LinkedList<>()));
        System.out.println("Distinct permutations by approach 2: " + approach2(arr, new ArrayList<Integer>(), new boolean[arr.length]));
        System.out.println("Distinct permutations by approach 3: " + approach3(new ArrayList<>(Arrays.stream(arr).boxed().toList()), 0, arr.length));
        System.out.println();
    }

    /**
     * Here, we are performing merge sort.
     * The time complexity is O(logN) for reducing array * O(N) for merging back.
     * The space complexity is O(N).
     */
    private static void sort(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }
        int m = (s + e) / 2;
        sort(arr, s, m);
        sort(arr, m, e);
        merge(arr, s, m, e);
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int[] res = new int[e - s];
        int i = s, j = m, k = 0;
        while (i < m && j < e) {
            res[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i < m) {
            res[k++] = arr[i++];
        }
        while (j < e) {
            res[k++] = arr[j++];
        }
        for (int x = 0; x < res.length; x++) {
            arr[s + x] = res[x];
        }
    }

    /**
     * Approach 1:
     * - The approach is simple, we are calculating all the distinct permutations here.
     * - The logic is simple if current element is already visited the skip finding permutation for the same.
     * - Also, if current is similar to previous element and previous is not visited then skip calculating permutation here.
     * - For rest of the cases, calculate permutations.
     * - Time complexity: O(N) for loop * O(N!) for calculating permutations = O(N*N!)
     * - Space complexity: O(N) for recursion stack + O(N) for visited array = O(2N) = O(N)
     */
    private static LinkedHashSet<List<Integer>> approach1(int[] arr, boolean[] visited, LinkedList<Integer> path) {
        if (path.size() == arr.length) {
            return new LinkedHashSet<List<Integer>>(List.of(new ArrayList<>(path)));
        }
        LinkedHashSet<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            // skip duplicates: if same as previous and previous not used in this position
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            path.add(arr[i]);
            result.addAll(approach1(arr, visited, path));
            path.removeLast();
            visited[i] = false;
        }
        return result;
    }

    /**
     * Approach 2:
     * - The approach is simple, we are calculating all the distinct permutations here.
     * - The logic is simple if current element is already visited then skip finding permutation for the same.
     * - Also, if current is similar to previous element and previous is not visited then skip calculating permutation here.
     * - For rest of the cases, calculate permutations.
     * - This is similar to approach 1, only here we are using arraylist instead of linked hashset.
     * - Time complexity: O(N) for loop * O(N!) for calculating permutations = O(N*N!)
     * - Space complexity: O(N) for recursion stack + O(N) for visited array = O(2N) = O(N)
     */
    private static List<List<Integer>> approach2(int[] arr, List<Integer> used, boolean[] visited) {
        if (used.size() == arr.length) {
            return new ArrayList<>(List.of(new ArrayList<>(used)));
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            used.add(arr[i]);
            list.addAll(approach2(arr, used, visited));
            used.removeLast();
            visited[i] = false;
        }
        return list;
    }

    /**
     * Approach 3:
     * - This is an alternative to approach 2.
     * - Here, we are using hashset to avoid duplicate permutations.
     * - We are also having 2 pointers left and right, left will move towards right, when both are equal we got our answer.
     * - We are adding the elements in set, if added successfully then we are swapping the left and i pointers.
     * - Then re-exploring the permutation and after that re-swapping to do backtracking.
     * - After completing the loop, we will be having distinct permutations.
     * - Time complexity: O(N) for loop * O(N!) to calculate permutations = O(N*N!)
     * - Space complexity: O(N) for recursion stack.
     */
    private static List<List<Integer>> approach3(List<Integer> arr, int l, int r) {
        if (l == r) {
            return new ArrayList<>(List.of(new ArrayList<>(arr)));
        }
        List<List<Integer>> list = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        for (int i = l; i < r; i++) {
            if (seen.add(arr.get(i))) {
                Collections.swap(arr, i, l);
                list.addAll(approach3(arr, l + 1, r));
                Collections.swap(arr, i, l);
            }
        }
        return list;
    }

}
