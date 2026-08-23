package module.one.sorting.implementationLab;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Sort a, b and c:
 *
 * Given an array containing elements a, b and c only in random order.
 * Place a at first then b and then c at last in the array.
 *
 * Input: arr = ['a', 'a', 'c', 'b', 'c', 'a', 'c', 'b', 'b', 'c', 'a', 'b', 'a']
 * Output: arr = ['a', 'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c']
 */
public class ThreePointers {

    public static void main(String[] args) {
        printArray(new char[]{'a', 'a', 'c', 'b', 'c', 'a', 'c', 'b', 'b', 'c', 'a', 'b', 'a'});
    }

    private static void printArray(char[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Approach 1 - Sorted Array: " + Arrays.toString(approach1(arr)));
        System.out.println("Approach 2 - Sorted Array: " + Arrays.toString(approach2(arr)));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach.
     * - We are using a TreeMap here to store the elements in sorted order along with its occurrence count.
     * - Creation of tree will take O(N*logN) and then creating the result array will take O(M*N) M is map size, N is count.
     * - Time: O(n log m) where n = arr.length and m = number of distinct characters.
     * For this problem m ≤ 3 so that simplifies to O(n). Reason: building the map costs O(n log m), writing the result
     * costs O(n).
     * = O(N*logM) + O(N) = O(N) + O(N) as M is constant here = O(2N) = O(N)
     * - Space: O(m) auxiliary for the TreeMap plus O(n) for the output array. For fixed alphabet (m constant) auxiliary space
     * is O(1).
     */
    private static char[] approach1(char[] arr) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char ch : arr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        char[] res = new char[arr.length];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                res[i++] = entry.getKey();
            }
        }
        return res;
    }

    /**
     * Approach 2 - Optimal
     * - This is better than the bruteforce approach.
     * - Here, we do not require any additional space to store distinct elements and occurrence count.
     * - We have 3 pointers, first 2 will point to first element and last one will point to last element.
     * - If char is 'a' then place is at region one by swap first 2 pointers and incrementing both by 1.
     * - If char is 'b' then simply increment first pointer, else swap first and last pointer and decrement last pointer.
     * - Repeat the process until first and last pointer becomes equal.
     * - At last the array will have the required answer.
     * - Time complexity: O(N) as we are iterating the array once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static char[] approach2(char[] arr) {
        int i = 0, j = 0, k = arr.length - 1;
        while (i <= k) {
            if (arr[i] == 'a') {
                swap(arr, i++, j++);
            } else if (arr[i] == 'b') {
                i++;
            } else {
                swap(arr, i, k--);
            }
        }
        return arr;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
