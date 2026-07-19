package module.two.tries.notes;

/**
 * Maximum XOR subarray:
 * <p>
 * Given an array [] of size, N. Find the subarray with maximum XOR. A subarray is a contiguous part of the array.
 * <p>
 * Example
 * Input: N = 4 array[] = {1,2,3,4}
 * Output: 7
 */
public class _5MaxXORSubArray {

    static class TrieNode {
        TrieNode[] binary = new TrieNode[2];
        int value = 0;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(int num) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int val = (num & (1 << i)) != 0 ? 1 : 0;
                if (node.binary[val] == null) {
                    node.binary[val] = new TrieNode();
                }
                node = node.binary[val];
            }
            node.value = num;
        }

        /**
         * Per-bit decision (loop i = 31 down to 0):
         * - Compute the current bit of num: val = ((num >> i) & 1).
         * - To maximize XOR at this bit, prefer a child whose bit is 1 - val (the opposite bit). XOR of differing bits yields 1
         * and contributes 1 << i to the final XOR.
         * - If node.binary[1 - val] exists, follow it (we greedily get a 1 at this bit). Otherwise follow node.binary[val]
         * (we must accept 0 at this bit).
         * - Continue to the next lower bit.
         */
        public int query(int num) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int val = (num & (1 << i)) != 0 ? 1 : 0;
                if (node.binary[1 - val] != null) {
                    node = node.binary[1 - val];
                } else if (node.binary[val] != null) {
                    node = node.binary[val];
                }
            }
            return num ^ node.value;
        }
    }

    public static void main(String[] args) {
        printMaxSubArrayXOR(new int[]{1, 2, 3, 4});
    }

    private static void printMaxSubArrayXOR(int[] nums) {
        System.out.println("Max sub array xor by approach 1: " + approach1(nums));
        System.out.println("Max sub array xor by approach 2: " + approach2(nums));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach.
     * - We are finding all the sub arrays and calculating the xor of it.
     * - The finding out the maximum xor and return it.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] nums) {
        int maxSubArrayXOR = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int subArrayXOR = 0;
            for (int j = i; j < nums.length; j++) {
                subArrayXOR ^= nums[j];
            }
            maxSubArrayXOR = Math.max(maxSubArrayXOR, subArrayXOR);
        }
        return maxSubArrayXOR;
    }

    /**
     * Approach 2 - Optimized:
     * - This is an optimized version where we are using Trie with Bit mask.
     * - The trie will story binary values of 32 bits.
     * - Will insert the xor values in trie and set the trie value as xor value.
     * - We have a query method to find the maximum xor of sub arrays.
     * - Time complexity: O(32 * N)
     * - Space complexity: O(32 * N)
     */
    private static int approach2(int[] nums) {
        int maxSubArrayXOR = Integer.MIN_VALUE, subArrayXOR = 0;
        Trie trie = new Trie();
        trie.insert(0);
        for (int num : nums) {
            subArrayXOR ^= num;
            trie.insert(subArrayXOR);
            maxSubArrayXOR = Math.max(maxSubArrayXOR, trie.query(subArrayXOR));
        }
        return maxSubArrayXOR;
    }

}