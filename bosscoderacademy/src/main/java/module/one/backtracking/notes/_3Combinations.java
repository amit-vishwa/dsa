package module.one.backtracking.notes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Print all possible combinations of r elements in a given array of size n:
 * <p>
 * Given an array of size n, generate and print all possible combinations of r elements in the array.
 * <p>
 * Example
 * Input: n = 4, arr[] = {1,2,3,4}, r = 2
 * Output: {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}  {3, 4}.
 */
public class _3Combinations {

    public static void main(String[] args) {
        printCombinations(4, 2);
        printCombinations(4, 3);
        printCombinations(4, 4);
        printCombinations(4, 5);
    }

    private static void printCombinations(int n, int r) {
        int[] arr = IntStream.rangeClosed(1, n).toArray();
//        arr = Stream.iterate(1, i -> i + 1).limit(n).mapToInt(x -> x).toArray();
        System.out.println("Combinations by approach 1: " + approach1(arr, n, r, 0, new ArrayList<>()));
        System.out.println("Combinations by approach 2: " + approach2(n, r, 0, new ArrayList<>()));
        System.out.println();
    }

    /**
     * Approach 1:
     * - Here, we are passing integer array along with other required fields like provided N, R which is combination size, index
     * to track current index so that 1,2 only added as pair and not 2,1.
     * - We are also providing empty list to store combinations.
     * - Now we are adding the current array element to combination and exploring next index.
     * - When combination size is equal to R that means we got our answer, we are adding that to combination list.
     * - Now, when we return then while backtracking we are removing the last added array element.
     * - At last we are simply returning all the combination list.
     * - Time complexity: O(N^R) for R combinations of N numbers.
     * - Space complexity: O(R) for recursion stack till combination is found, and O(N) for array.
     */
    private static List<List<Integer>> approach1(int[] arr, int n, int r, int index, List<Integer> combinations) {
        if (combinations.size() == r) {
            return new ArrayList<>(List.of(new ArrayList<>(combinations)));
        }
        List<List<Integer>> combinationList = new ArrayList<>();
        for (int i = index; i < n; i++) {
            combinations.add(arr[i]);
            combinationList.addAll(approach1(arr, n, r, i + 1, combinations));
            combinations.removeLast();
        }
        return combinationList;
    }

    /**
     * Approach 2:
     * - This is similar to approach 1 only, however we are not using any array here.
     * - We are directly using the index value to store it in the combination and last that is added in the result list.
     * - Time and space complexity is same here, only O(N) space is removed for array.
     */
    private static List<List<Integer>> approach2(int n, int r, int index, List<Integer> combination) {
        if (combination.size() == r) {
            return new ArrayList<>(List.of(new ArrayList<>(combination)));
        }
        List<List<Integer>> combinationList = new ArrayList<>();
        for (int i = index; i < n; i++) {
            combination.add(i + 1);
            combinationList.addAll(approach2(n, r, i + 1, combination));
            combination.removeLast();
        }
        return combinationList;
    }

}
