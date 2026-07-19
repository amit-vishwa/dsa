package module.two.queues.assignment;

/**
 * Gas Station:
 * <p>
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th
 * station. You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in
 * the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.
 * <p>
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * <p>
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1
 * <p>
 * Constraints:
 * n == gas.length == cost.length
 * 1 <= n <= 10^5
 * 0 <= gas[i], cost[i] <= 10^4
 */
public class _3GasStation {

    public static void main(String[] args) {
        System.out.println("Starting gas stations index: " + startingGasStation(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println("Starting gas stations index: " + startingGasStation(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    /**
     * Approach:
     * - The approach is quite optimal and simple to understand.
     * - We just have to iterate over the array of gas and cost to calculate total gas and cost.
     * - Also, calculate gas at current index, which is difference of gas and cost.
     * - If current gas is less than 0 then update start index to current index + 1.
     * - After, whole array iterations, check if total gas is less than total cost.
     * - If yes, then return -1 else return start index.
     * - Time complexity: O(N) as we are iterating over the array once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int startingGasStation(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, startIndex = -1, currentGas = 0, n = gas.length;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas = gas[i] - cost[i];
            if (currentGas < 0) {
                startIndex = i + 1;
            }
        }
        return totalGas < totalCost ? -1 : startIndex;
    }

}