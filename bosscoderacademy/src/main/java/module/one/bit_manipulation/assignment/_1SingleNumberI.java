package module.one.bit_manipulation.assignment;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Single Number 1:
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Input 1: nums = [2,2,1]
 * Output 1: 1
 * Explanation 1: 1 is present only once.
 *
 * Input 2: nums = [4,1,2,1,2]
 * Output 2: 4
 *
 * Constraints:
 * 1 <= nums.length <= 3*104
 * -3*104 <= nums[i] <= 3*104
 *
 * Approaches:
 * - There are various approaches to solve this problem, they are as follows:
 * 1. Bruteforce using nested loop - Time complexity: O(N^2), Space complexity: O(1)
 * 2. Better solution sort & iterate over array - Time complexity: O(NlogN) + (N), Space complexity: O(1)
 * 3. Approach 2 only, just perform binary search - Time complexity: O(NlogN) + O(logN), Space complexity: O(1)
 * 4. Better solution using hash - Time complexity: O(N) + O(Max), Space complexity: O(Max + 1)
 * 5. Optimal solution using map - Time complexity: O(N), Space complexity: O(N)
 * 6. Most optimal solution using XOR - Time complexity: O(N), Space complexity: O(1)
 */
public class _1SingleNumberI {

    public static void main(String[] args) {
        printDistinctElement(new int[]{2, 2, 1});
        printDistinctElement(new int[]{4, 1, 2, 1, 2});
        printDistinctElement(new int[]{4, 1, 2, 1, 2, 4});
        printDistinctElement(new int[]{4, 1, 2, 1, 2, 4, 0, -3, 0});
    }

    private static void printDistinctElement(int[] arr) {
        System.out.println("Distinct element by approach1 : " + approach1(arr));
        System.out.println("Distinct element by approach2 : " + approach2(arr));
        System.out.println("Distinct element by approach3 : " + approach3(arr));
        System.out.println("Distinct element by approach4 : " + approach4(arr));
        System.out.println("Distinct element by approach5 : " + approach5(arr));
        System.out.println("Distinct element by approach6 : " + approach6(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This is the simplest approach of all.
     * - Here, we just have to iterate over the array and for each element traverse whole array and maintain count.
     * - If count is 1, then return the element else proceed.
     * - At the end, after traversing the whole array if nothing found then return -1.
     * - Time complexity: O(N) iterating over array * O(N) re-iterating for each element = O(N*N) = O(N^2)
     * - Space complexity: O(1), no extra space is used
     */
    private static int approach1(int[] arr) {
        for (int num1 : arr) {
            int count = 0;
            for (int num2 : arr) {
                if (num1 == num2) {
                    count++;
                }
            }
            if (count == 1) {
                return num1;
            }
        }
        return -1;
    }

    /**
     * Approach 2 - Better approach
     * - This approach works on sorted array, so sort the array first.
     * - Then simply iterate over the array once from 0 to n-1.
     * - For each element, check if next is same, if not same then we got the answer.
     * - Return the element at current index, if not same proceed with other elements.
     * - At the end, after traversing till n-1 elements if array length is odd then return last element,
     * else nothing found return -1.
     * - Time complexity: O(Nlog(N)) sort array * O(N) iterate array for distinct element = O(Nlog(N) + O(N) = O(Nlog(N))
     * - Space complexity: O(1), no extra space is used
     */
    private static int approach2(int[] arr) {
        int[] sortedArray = sort(arr);
        int n = sortedArray.length;
        for (int i = 0; i < n - 1; i += 2) {
            if (sortedArray[i] != sortedArray[i + 1]) {
                return sortedArray[i];
            }
        }
        return (n & 1) == 1 ? sortedArray[arr.length - 1] : -1;
    }

    private static int[] sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return arr;
        }
        int[] left = sort(Arrays.copyOfRange(arr, 0, n / 2));
        int[] right = sort(Arrays.copyOfRange(arr, n / 2, n));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0, m = left.length, n = right.length;
        int[] res = new int[m + n];
        while (i < m && j < n) {
            res[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
        }
        while (i < m) {
            res[k++] = left[i++];
        }
        while (j < n) {
            res[k++] = right[j++];
        }
        return res;
    }

    /**
     * Approach 3 - Better approach than approach 2
     * - This is similar to approach 2, only the difference here is that we are using binary search instead of iteration.
     * - Here, we are performing binary search on sorted array and checking if mid is not the last index and elements at
     * mid and mid^1 are same.
     * - If they are same that means we are at the region where elements are getting repeated twice and both elements at
     * odd and even index are same, the distinct element will update this so that odd index will have first occurrence
     * and even will have repetition.
     * - So, here we will update left pointer to mid + 1, else will update right pointer to mid - 1.
     * - At the end, the left pointer will have the index of distinct element if it is not the last index of even length array.
     * - Time complexity: O(Nlog(N)) sorted array + O(logN) binary search = O(N*log(N)) + O(log(N)) = O(N*log(N))
     * - Space complexity: O(1), no extra space is used here.
     * - Note: If array is already sorted then perform binary search it is most optimal in this case.
     */
    private static int approach3(int[] arr) {
        int[] sortedArray = sort(arr);
        int n = sortedArray.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m != n - 1 && sortedArray[m] == sortedArray[m ^ 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (l == n - 1 && (n & 1) != 1) ? -1 : sortedArray[l];
    }

    /**
     * Approach 4 - Better approach
     * - This is the better approach than all above, but it only works with whole numbers.
     * - Here, we just have to iterate over the array and calculate min and max element.
     * - Then create an array to store the occurrence count of elements, size will be max + 1.
     * - Then we will iterate over the newly created or hash array from min to max to check the count.
     * - If we found count 1 for any index, then return that index else continue the process.
     * - At the end, after traversing the whole array if nothing found then return -1.
     * - Time complexity: O(N) iterate array + O(Max-Min) hash array iteration = O(N) + O(Max-Min)
     * - Space complexity: O(Max+1) for creating the hash array to store element occurrence count.
     */
    private static int approach4(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] hash = new int[max + 1];
        for (int num : arr) {
            if (num >= 0) {
                hash[num]++;
            }
        }
        for (int i = Math.max(min, 0); i <= max; i++) {
            if (hash[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 5 - Optimal approach
     * - This is the modified version of approach 4.
     * - Here, we are using map to store the element count.
     * - Iterate over the array and insert element with its count in map.
     * - Then iterate over the map and check the map value, if it is 1 then return the key else proceed till end.
     * - At the end, after traversing the whole map if nothing found then return -1.
     * - Time complexity: O(N) iterating over array + O(N) iterating over map = O(N) + O(N) = O(2N) = O(N), assuming both have same size
     * - Space complexity: O(N) for creating the map
     */
    private static int approach5(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * Approach 6 - Most optimal approach
     * - This is the simplest and most optimal approach of all.
     * - Here, we just have to iterate over the array and XOR all elements, start with 0 or first element.
     * - At the end, after traversing the whole array return the result, it will have the distinct element or 0.
     * - Time complexity: O(N) iterating over array once
     * - Space complexity: O(1) no extra space is used.
     */
    private static int approach6(int[] arr) {
        int res = 0;
        for (int num : arr) {
            res ^= num;
        }
        return res;
    }

}