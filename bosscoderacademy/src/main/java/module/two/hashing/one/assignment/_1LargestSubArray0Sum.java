package module.two.hashing.one.assignment;

import java.util.HashMap;

// Refer _2LargestSubArray0Sum.java from package module.two.hashing.one.notes;
public class _1LargestSubArray0Sum {

    public static void main(String[] args) {
        printSubArraySize(new int[]{15, -2, 2, -8, 1, 7, 10, 23});
        printSubArraySize(new int[]{1, 2, 3});
    }

    private static void printSubArraySize(int[] arr) {
        System.out.println("Largest sub array size by approach 1: " + approach1(arr));
        System.out.println("Largest sub array size by approach 2: " + approach2(arr));
        System.out.println();
    }

    private static int approach1(int[] arr) {
        int maxSize = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    maxSize = Math.max(maxSize, j - i + 1);
                }
            }
        }
        return maxSize;
    }

    private static int approach2(int[] arr) {
        int maxSize = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxSize = i + 1;
            }
            if (map.containsKey(sum)) {
                maxSize = Math.max(maxSize, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxSize;
    }

}