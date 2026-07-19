package module.two.stacks.assignment;

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
public class _7GasStation {

    public static void main(String[] args) {
        System.out.println("Starting gas station: " + startGasStationIndex(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println("Starting gas station: " + startGasStationIndex(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    /**
     * Approach:
     * - The approach is quite simple.
     * - Just calculate sum of both arrays, i.e. gas and cost.
     * - Also, calculate current gas which is nothing but difference of gas and cost.
     * - If current gas is less than 0 i.e. no more petrol left, initialize gas to 0 and restart from next index and
     * reiterate the process.
     * - After iterating the arrays, just check if total gas is less than total cost then return -1 else return start index.
     * - Time complexity: O(N) as we are iterating the arrays once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int startGasStationIndex(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, curGas = 0, startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                startIndex = i + 1;
                curGas = 0;
            }
        }
        return totalGas < totalCost ? -1 : startIndex;
    }

}