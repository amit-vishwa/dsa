package module.one.searching.one.lecture;

/**
 * Last occurrence index of target:
 * Find the index of the last occurrence of the given target from given array.
 * We have two ways to solve this, linear search and binary search.
 */
public class LastOccurrence {

    public static void main(String[] args) {
        printLastOccurrence(new int[]{2, 3, 3, 5, 7, 7, 8, 8, 8, 12, 12}, 8);
        printLastOccurrence(new int[]{2, 3, 3, 5, 7, 7, 8, 8, 8, 12, 12}, 12);
        printLastOccurrence(new int[]{2, 2, 3, 3, 5, 7, 7, 8, 8, 8, 12, 12}, 2);
        printLastOccurrence(new int[]{2, 2, 3, 3, 5, 7, 7, 8, 8, 8, 12, 12}, 4);
        printLastOccurrence(new int[]{2, 3, 3, 5, 7, 7, 8, 8, 8, 12, 12}, 1);
        printLastOccurrence(new int[]{2, 3, 3, 5, 7, 7, 8, 8, 8, 12, 12}, 13);
    }

    private static void printLastOccurrence(int[] arr, int t) {
        System.out.println("Last occurrence index by approach1: " + approach1(arr, t));
        System.out.println("Last occurrence index by approach2: " + approach2(arr, t));
        System.out.println("Last occurrence index by approach3: " + approach3(arr, t));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This is the bruteforce approach where we are applying linear search algorithm to find the first occurrence.
     * - We are simply iterating the sorted array from last index, as this will simply give the last index.
     * - Time complexity: O(N) as we are iterating the whole array.
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int approach1(int[] arr, int t) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == t) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 2 - Optimal approach
     * - Here we are using Binary search algorithm to find the last index.
     * - We are using a variable to store the potential answer if target found.
     * - Then we will simply reduce the search space by updating left pointer pointing to mid-index.
     * - Else if target is greater than mid-element then update left pointer to mid + 1.
     * - Else update right pointer to mid - 1;
     * - Time complexity: O(log(N)) as it is a simple binary search.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] arr, int t) {
        int l = 0, r = arr.length - 1, index = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == t) {
                index = m;
                l = m + 1;
            } else if (arr[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return index;
    }

    /**
     * Approach 3 - Optimal approach
     * - This is approach 2 only but without using any extra variable to store potential answer.
     * - Here, we are already handling few edge cases like target not in the range of array elements or array is empty,
     * in the start itself before performing binary search.
     * - Just perform a simple binary search and instead of returning middle index when target found, just update the left
     * pointer to mid + 1 and at last return the right pointer as it will have answer.
     * - If it is then return it else return -1.
     * - Time and space complexity is similar to approach 2.
     */
    private static int approach3(int[] arr, int t) {
        int n = arr.length;
        if (n == 0 || t > arr[n - 1] || t < arr[0]) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] > t) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return arr[r] != t ? -1 : r; // right pointer will have the answer
    }

}
