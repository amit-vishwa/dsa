package module.one._1d_and_2d_array.assignment;

/**
 * Max Chunks Sorted Ii:
 * <p>
 * You are given an integer array arr.
 * We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After
 * concatenating them, the result should equal the sorted array.
 * Return the largest number of chunks we can make to sort the array.
 * <p>
 * Input 1: arr = [5,4,3,2,1]
 * Output 1: 1
 * Explanation 1: Splitting into two or more chunks will not return the required result. For example, splitting
 * into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
 * <p>
 * Input 2: arr = [2,1,3,4,4]
 * Output 2: 4
 * <p>
 * Constraints:
 * n == arr.length
 * 1 <= n <= 2000
 * 0 <= arr[i] < 108
 * <p>
 * Approaches: refer SortedChunksTwo.java file from module.one._1d_and_2d_array.lecture.day3 package.
 */
public class _7MaxChunksSorted {

    public static void main(String[] args) {
        System.out.println("Max chunks sorted: " + solve(new int[]{5, 4, 3, 2, 1}));
        System.out.println("Max chunks sorted: " + solve(new int[]{2, 1, 3, 4, 4}));
    }

    // Space and time complexity: O(N)
    private static int solve(int[] input) {
        int chunks = 0, n = input.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        leftMax[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], input[i - 1]);
        }
        rightMin[n - 1] = input[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], input[i]);
        }
        for (int i = 0; i < n; i++) {
            if (leftMax[i] <= rightMin[i]) {
                chunks++;
            }
        }
        return chunks;
    }

}