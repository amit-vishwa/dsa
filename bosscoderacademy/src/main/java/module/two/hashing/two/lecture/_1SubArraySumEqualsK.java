package module.two.hashing.two.lecture;

import java.util.HashMap;

// Refer _3SubArraySumK.java from package module.two.hashing.one.assignment;
public class _1SubArraySumEqualsK {

    public static void main(String[] args) {
        printSubArrayCount(new int[]{1, 1, 1}, 2);
        printSubArrayCount(new int[]{1, 2, 3}, 3);
        printSubArrayCount(new int[]{1, 2, 3}, 4);
        printSubArrayCount(new int[]{1, 1, 1}, 1);
        printSubArrayCount(new int[]{-1, 1, -1, 1, 0, 1, -1, 1}, 1);
    }

    private static void printSubArrayCount(int[] nums, int k) {
        System.out.println("Sub array count whose sum equals to K by approach 1: " + approach1(nums, k));
        System.out.println("Sub array count whose sum equals to K by approach 2: " + approach2(nums, k));
        System.out.println();
    }

    private static int approach1(int[] nums, int k) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int approach2(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            int complement = prefixSum - k;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

}
