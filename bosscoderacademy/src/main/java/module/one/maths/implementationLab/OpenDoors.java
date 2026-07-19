package module.one.maths.implementationLab;

/**
 * Refer the problem here:
 * https://www.geeksforgeeks.org/problems/number-of-open-doors1552/1
 */
public class OpenDoors {

    public static void main(String[] args) {
        printOpenDoors(2);
        printOpenDoors(4);
        printOpenDoors(23);
    }

    private static void printOpenDoors(int n) {
        System.out.println("Open doors count by approach1: " + approach1(new boolean[n + 1], n));
        System.out.println("Open doors count by approach2: " + approach2(n));
        System.out.println();
    }

    /**
     * Approach 1: Bruteforce approach
     * - Here, this is a simple approach where we are taking a boolean array of n+1 size.
     * - Then we are iterating over the array and for each index we are re-iterating again by skipping index number of doors.
     * - After doing all these, we are then simply iterating the array and counting the number of open doors.
     * - Time complexity: O(N) array iteration * O(N) open or closing the doors + O(N) counting open doors
     * i.e. (O(N) * O(N)) + O(N) = O(N^2) + O(N) = O(N^2) as we ignore smaller values.
     * - Space complexity: O(N+1) for boolean array
     */
    private static int approach1(boolean[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                arr[j] ^= true;
            }
        }
        int openDoors = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i]) {
                openDoors++;
            }
        }
        return openDoors;
    }

    /**
     * Approach 2:
     * - This is the most optimal approach.
     * - If we observe carefully, then we can see that perfect squares have odd factors.
     * - And after reaching at a door we can see that it will be opened or closed by its factors only.
     * - Consider door 10, so only 1,2,5,10 will open or close it, and since it is even then the door will get closed again
     * which means the state will remain unchanged for even factors and only for odd factors it will be changed i.e. opened.
     * - Now take square root of 10, we will get 3. some decimal value, which means 1, 4 and 9 are perfect squares under 10.
     * - So here 3 doors state will be changed i.e. it will be opened at end.
     * - Now consider total doors are 23, we take its square root which is 4 in integer value, which mean 4 doors will open.
     * - Time complexity: O(log(N)) for calling Math.sqrt(), Space complexity: O(1)
     */
    private static int approach2(int doors) {
        return (int) Math.sqrt(doors);
    }

}
