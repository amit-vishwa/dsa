package module.one.maths.two.assignment;

import java.util.HashMap;

/**
 * Array Pair Divisible By K:
 * <p>
 * Given an array of integers arr of even length n and an integer k. We want to divide the array into exactly n / 2 pairs
 * such that the sum of each pair is divisible by k.
 * Return true If you can find a way to do that or false otherwise.
 * <p>
 * Input 1: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * Output 1: true
 * Explanation 1: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
 * <p>
 * Input 2: arr = [1,2,3,4,5,6], k = 10
 * Output 2: false
 * <p>
 * Constraints:
 * 1 <= arr.length <= 105
 * -109 <= arr[i] <= 109
 * arr.length is even
 * 1 <= k <= 105
 */
public class _3PairSumDivisibleByK {

    public static void main(String[] args) {
        printIfPairsDivisibleByK(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5);
        printIfPairsDivisibleByK(new int[]{1, 2, 3, 4, 5, 6}, 10);
    }

    private static void printIfPairsDivisibleByK(int[] arr, int k) {
        System.out.println("Approach 1: Are array pairs sum divisible by K? " + approach1(arr, k));
        System.out.println("Approach 2: Are array pairs sum divisible by K? " + approach2(arr, k));
        System.out.println("Approach 3: Are array pairs sum divisible by K? " + approach3(arr, k));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - The logic is simple for this bruteforce approach.
     * - The simple first check is whether array length is odd or even, if it is odd then all pairs cannot be divisible by k.
     * - As we will always have one element left for odd numbers.
     * - Now, we can iterate over the array and for each element we have to check whether there is any other element in the
     * array whose pair sum is divisible by k.
     * - We can use a boolean flag for the same, and initially the value can be false, but once found pair then it becomes true.
     * - Also, after finding the pair for the element, we can simply break the loop as we only want at least one pair.
     * - After coming out of the loop, after completing the inner loop we can check flag state, if not changed then
     * return false as we do not have a sum of pair divisible by K for that element.
     * - After doing the iteration for all elements, we can return true at the end.
     * - Time complexity: O(N^2) as we are using nested loop.
     * - Space complexity: O(1) as we are not using any extra space.
     */
    private static boolean approach1(int[] arr, int k) {
        int n = arr.length;
        if (n % 2 == 1) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            boolean isPairSumDivisible = false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if ((arr[i] + arr[j]) % k == 0) {
                    isPairSumDivisible = true;
                    break;
                }
            }
            if (!isPairSumDivisible) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 2 - Optimal approach
     * - This is an optimal approach where we are using hashing technique to store remainders count.
     * - The logic is simple, first do the initial check of array length, if odd then all pairs cannot be created so false.
     * - Then create an array of size K, this is store the remainders count.
     * - Then, we will check if remainder 0 count is in even or not, as remainder of 0 and N should be 0, so count is 2 here.
     * - So, if we have remainder 0 count other than even numbers then we can say pair sum is not divisible by K, as i=0
     * and k-i will become k which is out of bounds, so it should have even numbed of occurrences.
     * - Now, we have to iterate over the frequency array from 1st index till K/2 index, i.e. only half way.
     * - For each element or remainder occurrence count, will compare it with K-i, i.e. count at index i should be equal to
     * count at index K-i.
     * - Because, if i + K - i = K, i.e. we have to find remainders whose sum should be equal to K, so for i it is K-i.
     * - If count at index i and K-i doesn't match, then return false.
     * - Else, at the end i.e. after frequency array traversal completion return true.
     * - Time complexity: O(N) traversing array to find remainders + O(K) traversing frequency array to check divisibility
     * = O(N) + O(K) = O(N + K) = O(N) as K is smaller than N so can be ignored.
     * - Space complexity: O(K) for creating the frequency array.
     */
    private static boolean approach2(int[] arr, int k) {
        if (arr.length % 2 == 1) {
            return false;
        }
        int[] freq = new int[k];
        for (int n : arr) {
            int rem = ((n % k) + k) % k;
            freq[rem]++;
        }
        if (freq[0] % 2 == 1) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 3 - Optimal approach
     * - This is similar to approach 2 only, but it is used for large number of K values.
     * - Also, here we have to take care elements whether they are present in frequency map, add proper checks.
     * - Time and space complexity is similar to approach 2 only.
     */
    private static boolean approach3(int[] arr, int k) {
        if (arr.length % 2 == 1) {
            return false;
        }
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int n : arr) {
            int rem = ((n % k) + k) % k;
            freqMap.put(rem, freqMap.getOrDefault(rem, 0) + 1);
        }
        if (freqMap.containsKey(0) && freqMap.get(0) % 2 == 1) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (!freqMap.get(i).equals(freqMap.get(k - i))) {
                return false;
            }
        }
        return true;
    }

}