package module.two.greedy.lecture;

import java.util.HashSet;

// Refer _4DistributeCandies.java from package module.one.exams.one.
public class _2DistributeCandies {

    public static void main(String[] args) {
        System.out.println("The maximum number of different types of candies that Alice can eat is " + maxCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println("The maximum number of different types of candies that Alice can eat is " + maxCandies(new int[]{1, 1, 2, 3}));
        System.out.println("The maximum number of different types of candies that Alice can eat is " + maxCandies(new int[]{6, 6, 6, 6}));
    }

    private static int maxCandies(int[] candyType) {
        HashSet<Integer> uniqueCandies = new HashSet<>();
        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }
        int halfOfTotalCandies = candyType.length / 2;
        int uniqueCandiesCount = uniqueCandies.size();
        int maxEatableCandies = Math.min(halfOfTotalCandies, uniqueCandiesCount);
        return maxEatableCandies;
    }

}
