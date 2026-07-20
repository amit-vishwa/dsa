package module.one._1d_and_2d_array.lecture.day3;

/**
 * [Leetcode 768. Max Chunks To Make Sorted II]
 * The problem is similar to sorted chunks one, only the condition of 0 to n-1 is removed here.
 * The elements can be of any range.
 * <p>
 * Example: arr = [2,1,3,4,4], ans = 4, chunks = [2,1],[3],[4],[4]
 * <p>
 * Approaches - approaches are similar to previous problem only, but for optimal we are using arrays here.
 */
public class SortedChunksTwo {

    public static void main(String[] args) {
        System.out.println("Max sorted chunks: " + maxChunks(new int[]{2, 1, 3, 4, 4}));
        System.out.println("Max sorted chunks: " + maxChunks(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Max sorted chunks: " + maxChunks(new int[]{5, 4, 3, 2, 1}));
    }

    /**
     * Optimal approach:
     * - Here, we are storing the max lefts till previous element in an array.
     * - Also, array is created to store min rights till current element.
     * - Now, we are just checking for current element if max left <= min right.
     * - If true, then increase the chunks as we can create a sorted chunk out of it, else skip.
     * - Time and space complexity is O(N).
     */
    private static int maxChunks(int[] arr) {
        int n = arr.length, chunks = 0;
        int[] maxLeftArray = new int[n];
        int[] minRightArray = new int[n];
        maxLeftArray[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            // storing max element till previous element only
            maxLeftArray[i] = Math.max(maxLeftArray[i - 1], arr[i - 1]);
        }
        minRightArray[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // storing min element from end index till current index element
            minRightArray[i] = Math.min(minRightArray[i + 1], arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (maxLeftArray[i] <= minRightArray[i]) {
                chunks++;
            }
        }
        return chunks;
    }

}
