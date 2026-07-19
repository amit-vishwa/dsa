package module.two.greedy.lecture;

import java.util.Arrays;

// Refer https://www.geeksforgeeks.org/dsa/activity-selection-problem-greedy-algo-1/
public class _1ActivitySelection {

    public static void main(String[] args) {
        System.out.println("Max activities can be performed without overlapping: " + maxNonOverlappingActivities(new int[]{1, 3, 0, 5, 8, 5},
                new int[]{2, 4, 6, 7, 9, 9}));
        System.out.println("Max activities can be performed without overlapping: " + maxNonOverlappingActivities(new int[]{10, 12, 20},
                new int[]{20, 25, 30}));
        System.out.println("Max activities can be performed without overlapping: " + maxNonOverlappingActivities(new int[]{5, 1, 3, 0},
                new int[]{9, 2, 4, 6}));
    }

    /**
     * Approach:
     * - The Greedy approach is a bit logical.
     * - We just have to create a 2D array where we are storing the start and end time.
     * - Then sort the array based on end time first, if same then sort by start time.
     * - Now just iterate over 2D array and check if start of next is greater than the end of previous.
     * - A counter variable is there to keep track of count, it starts with 1 as at least 1 activity can be completed.
     * - If above condition is true, then increment the counter and update the i index by storing j value in it.
     * - Time complexity: O(N*log(N)) for sorting activities + O(N) for iterating over it = O(N*log(N))
     * - Space complexity: O(N) as we are using extra 2D array here.
     */
    private static int maxNonOverlappingActivities(int[] start, int[] end) {
        int n = start.length;
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = end[i];
        }
        // sort by end time, if same sort by start time
        Arrays.sort(activities, (activity1, activity2) -> (activity1[1] == activity2[1]) ? activity1[0] - activity2[0] :
                activity1[1] - activity2[1]);
        int maxNonOverlappingActivitiesCount = 1;
        for (int i = 0, j = 1; j < n; j++) {
            if (activities[j][0] > activities[i][1]) {
                i = j;
                maxNonOverlappingActivitiesCount++;
            }
        }
        return maxNonOverlappingActivitiesCount;
    }

}
