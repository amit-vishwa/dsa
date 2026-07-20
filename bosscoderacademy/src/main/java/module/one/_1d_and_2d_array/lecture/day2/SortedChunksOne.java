package module.one._1d_and_2d_array.lecture.day2;

/**
 * Max chunks to make the array sorted: [Leetcode 769. Max Chunks To Make Sorted]
 * Given an array which may or may not be sorted with elements from 0 - (n-1).
 * Return the max chunks that we can create out of it, which should give a sorted array after merge.
 * <p>
 * Example 1: arr = [2,0,1,4,3,5], ans = 3, chunks = [2,0,1],[4,3],[5]
 *
 * Approaches:
 * 1. Bruteforce - we can create all sub-arrays then sort and merge it to get solution.
 * 2. Optimal - we can store max val till current element and compare with index and increase chunks count.
 */
public class SortedChunksOne {

    public static void main(String[] args) {
        System.out.println("Max sorted chunks: " + maxSortedChunks(new int[]{2, 0, 1, 4, 3, 5}));
    }

    /**
     * Optimal approach:
     * - As it is already mentioned that elements exist from 0 to n-1.
     * - We can take advantage of this and store max value till the element in a variable.
     * - Then we will check if max is equal to index.
     * - We have to create a counter for chunks and increase it if max == index.
     * - Time complexity: O(N), as it will traverse the array only once
     * - Space complexity: O(1)
     */
    private static int maxSortedChunks(int[] arr) {
        int chunks = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                chunks++;
            }
        }
        return chunks;
    }

}
