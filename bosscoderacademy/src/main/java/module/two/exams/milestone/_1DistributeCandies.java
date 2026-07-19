package module.two.exams.milestone;

import java.util.HashSet;

// Refer: _4DistributeCandies.java from package module.one.exams.one.
public class _1DistributeCandies {

    public static void main(String[] args) {
        System.out.println("Alice can eat " + candies(new int[]{1, 1, 2, 2, 3, 3}) + " candies");
        System.out.println("Alice can eat " + candies(new int[]{1, 1, 2, 3}) + " candies");
    }

    private static int candies(int[] candyType) {
        HashSet<Integer> uniqueCandies = new HashSet<>();
        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }
        return Math.min(uniqueCandies.size(), candyType.length / 2);
    }

}
