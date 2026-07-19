package module.two.linkedlist.one.assignment;

/**
 * Koko Eating Bananas:
 * <p>
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will
 * come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from
 * that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * <p>
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * <p>
 * Constraints:
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */
public class _7KokoEatingBananas {

    public static void main(String[] args) {
        System.out.println("Minimum bananas Koko can eat in h hours are " + binarySearch(new int[]{3, 6, 7, 11}, 8));
        System.out.println("Minimum bananas Koko can eat in h hours are " + binarySearch(new int[]{30, 11, 23, 4, 20}, 5));
    }

    /**
     * Approach:
     * - The approach is kind of similar to shipment and magnetic force problems.
     * - Here, the logic is a bit different, we have to take min and max as two bounds of binary search.
     * - Now start with the binary search loop and calculate mid.
     * - Then calculate the time taken to eat all bananas, which is nothing but sum of ceil value of (pile/speed).
     * - If is taking more time than the specified one, then just increase the speed i.e. lower bound.
     * - Else just keep the upper bound as current speed.
     * - At last, both lower and upper will have the answer just return any one of them.
     * - Time complexity: O(log(N)) for binary search * O(M) for iterating array = O(M*log(N))
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int binarySearch(int[] piles, int hours) {
        int low = 1, high = Integer.MIN_VALUE;
        for (int pile : piles) {
            high = Math.max(pile, high);
        }
        while (low < high) {
            int speed = (low + high) / 2;
            int totalTime = getCount(piles, speed);
            if (totalTime > hours) {
                low = speed + 1;
            } else {
                high = speed;
            }
        }
        return high;
    }

    private static int getCount(int[] piles, int speed) {
        int totalTime = 0;
        for (int pile : piles) {
            // below 2 lines are equivalent to Math.ceil((double)sum / speed)
            int sum = pile + speed - 1;
            totalTime += sum / speed;
        }
        return totalTime;
    }


}