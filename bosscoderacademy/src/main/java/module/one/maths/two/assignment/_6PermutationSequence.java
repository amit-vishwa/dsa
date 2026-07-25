package module.one.maths.two.assignment;

import java.util.ArrayList;

/**
 * Permutation Sequence: [Leetcode 60. Permutation Sequence]
 * <p>
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * <p>
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Input: n = 3, k = 3
 * Output: "213"
 * <p>
 * Input: n = 4, k = 9
 * Output: "2314"
 * <p>
 * Constraints:
 * 1 <= n <= 9
 * 1 <= k <= n!
 */
public class _6PermutationSequence {

    public static void main(String[] args) {
        System.out.println("Kth permutation: " + kthPermutation(3, 3));
        System.out.println("Kth permutation: " + kthPermutation(4, 9));
        System.out.println("Kth permutation optimal: " + kthPermutationOptimal(3, 3));
        System.out.println("Kth permutation optimal: " + kthPermutationOptimal(4, 9));
    }

    /**
     * Approach:
     * - This is a quite complex approach.
     * - First, we are creating all permutations for given string which is first N natural numbers.
     * - Then, we have to sort the permutation list.
     * - Then we can return the kth permutation string.
     * - Time complexity: O(N) for creating initial string + O(N*N!) for finding all permutations + O(N*logN) sorting list
     * = O(N) + O(N*N!) + O(N*logN) = O(N*N!) + O(N!*logN!) as we can ignore all lower significance terms
     * - Space complexity: O(N*N!) as we are storing permutations in a list.
     */
    private static String kthPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) { // O(N)
            sb.append(i);
        }
        ArrayList<String> permutationList = permutations("", sb.toString()); // O(N*N!)
        permutationList.sort(null); // O(N*logN)
        return permutationList.get((k - 1) % permutationList.size());
    }

    // Time complexity: O(N) * O(N!) = O(N*N!)
    private static ArrayList<String> permutations(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            ArrayList<String> permutation = new ArrayList<>();
            permutation.add(processed); // O(N) space
            return permutation;
        }
        ArrayList<String> permutationList = new ArrayList<>();
        for (int i = 0; i <= processed.length(); i++) {
            String leftString = processed.substring(0, i);
            char midString = unProcessed.charAt(0);
            String rightString = processed.substring(i);
            // below list will have O(N!) space and each element is of O(N) space, total is O(N!) * O(N) = O(N*N!)
            permutationList.addAll(permutations(leftString + midString + rightString, unProcessed.substring(1)));
        }
        return permutationList;
    }

    /**
     * Approach:
     * - Create a list of numbers and factorials till N.
     * - Then make K 0-based and iterate number in reverse order till 1.
     * - At every step, do below:
     * i. Calculate block size, which is factorial of remaining number - 1
     * ii. Calculate index, which is nothing but k / size
     * iii. Choose the number at that index from number list and append it to answer string
     * iv. Remove the number at that index from list
     * v. Then update the value of K, which is nothing but modulo of K with block size.
     * - At last, return the answer as String.
     * - Time complexity: O(N) for num list and factorials + (O(N) for iteration from N to 1 * O(N) for num removal from list)
     * = O(N) + O(N*N) = O(N) + O(N^2) = O(N^2) as smaller numbers are ignored
     * - Space complexity: O(N) for list
     */
    private static String kthPermutationOptimal(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            fact[i] = fact[i - 1] * i;
        }
        k--;
        StringBuilder ans = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int size = fact[i - 1];
            int index = k / size;
            ans.append(nums.get(index));
            nums.remove(index);
            k %= size;
        }
        return ans.toString();
    }

}