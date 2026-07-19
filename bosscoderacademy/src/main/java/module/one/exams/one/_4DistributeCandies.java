package module.one.exams.one;

import java.util.HashSet;

/**
 * LeetCode 575. Distribute Candies
 * Refer: https://leetcode.com/problems/distribute-candies/description/
 */
public class _4DistributeCandies {

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(distributeCandies(new int[]{1, 1, 2, 3}));
        System.out.println(distributeCandies(new int[]{6, 6, 6, 6}));
    }

    /**
     * Approach:
     * - The approach is simple, we just have to divide whole candy set.
     * - And also, we have to count the unique candies from given candy set.
     * - Now, we have to check which one is smaller.
     * - The smallest among both is the answer here.
     * - Time complexity: O(N) as we are iterating over the array
     * - Space complexity: O(N) i.e. unique candies stored in a set.
     */
    private static int distributeCandies(int[] candyType) {
        HashSet<Integer> distinctCandies = new HashSet<>();
        for (int candy : candyType) {
            distinctCandies.add(candy);
        }
        return Math.min(distinctCandies.size(), candyType.length / 2);
    }

}
