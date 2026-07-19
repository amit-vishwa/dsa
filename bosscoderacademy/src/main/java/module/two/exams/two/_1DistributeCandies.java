package module.two.exams.two;

import java.util.HashSet;

// Refer _4DistributeCandies.java from package module.one.exams.one.
public class _1DistributeCandies {

    public static void main(String[] args) {
        System.out.println("Alice can eat only " + maxCandies(new int[]{1, 1, 2, 2, 3, 3}) + " candies");
        System.out.println("Alice can eat only " + maxCandies(new int[]{1, 1, 2, 3}) + " candies");
        System.out.println("Alice can eat only " + maxCandies(new int[]{6, 6, 6, 6}) + " candies");
    }

    private static int maxCandies(int[] candyType) {
        HashSet<Integer> uniqueCandies = new HashSet<>();
        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }
        int halfOfTotalCandies = candyType.length / 2;
        int uniqueCandiesCount = uniqueCandies.size();
        return Math.min(halfOfTotalCandies, uniqueCandiesCount);
    }

}
