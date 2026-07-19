package module.two.tries.notes;

/**
 * Pair with max XOR:
 * <p>
 * Given an integer array numbers, return the maximum result of numbers[i] XOR numbers[j], where 0 <= i <= j < n.
 * <p>
 * Example
 * Input: numbers = [3,10,5,25,2,8]
 * Output: 28
 */
public class _4MaxPairXOR {

    static class TrieNode {
        TrieNode[] binary = new TrieNode[2];
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(int num) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.binary[bit] == null) {
                    node.binary[bit] = new TrieNode();
                }
                node = node.binary[bit];
            }
        }

        public int xorMax(int num) {
            int max = 0;
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.binary[1 - bit] != null) {
                    max = max | (1 << i);
                    node = node.binary[1 - bit];
                } else {
                    node = node.binary[bit];
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        printMaxPairXor(new int[]{3, 10, 5, 25, 2, 8});
    }

    private static void printMaxPairXor(int[] nums) {
        System.out.println("Max pair xor by approach 1: " + approach1(nums));
        System.out.println("Max pair xor by approach 2: " + approach2(nums));
        System.out.println();
    }

    /**
     * Approach 1:
     * - This is a simple bruteforce approach.
     * - We are iterating over nums array using nest loop to calculate xor of pairs.
     * - Then, we are finding the max among them and returning it.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    /**
     * Approach 2:
     * - This is an optimized approach using Trie with Bit manipulation.
     * - We have created a Trie that stores 32 bits in 0 and 1 format.
     * - We are finding max of xor by checking if 1 - current bit position exists, then OR it in result.
     * - At last just return the answer.
     * - Time complexity: O(32 * N) due to 32 bits = O(N)
     * - Space complexity: O(32 * N) as numbers are not fixed = O(N)
     */
    private static int approach2(int[] nums) {
        int max = Integer.MIN_VALUE;
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
        }
        for (int num : nums) {
            max = Math.max(max, trie.xorMax(num));
        }
        return max;
    }

}