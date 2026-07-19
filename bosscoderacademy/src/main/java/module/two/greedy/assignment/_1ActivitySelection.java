package module.two.greedy.assignment;

import java.util.Arrays;
import java.util.ArrayList;

// Refer _1ActivitySelection.java from package module.two.greedy.lecture.
public class _1ActivitySelection {

    public static void main(String[] args) {
        System.out.println("Activities start indices: " + Arrays.toString(maxActivitiesPerformed(new int[]{10, 12, 20}, new int[]{20, 25, 30})));
        System.out.println("Activities start indices: " + Arrays.toString(maxActivitiesPerformed(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9})));
    }

    private static int[] maxActivitiesPerformed(int[] start, int[] finish) {
        int n = start.length;
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i] = new int[]{start[i], finish[i]};
        }
        Arrays.sort(activities, (activity1, activity2) -> (activity1[1] == activity2[1]) ? activity1[0] - activity2[0] : activity1[1] - activity2[1]);
        ArrayList<Integer> activitiesIndices = new ArrayList<>();
        activitiesIndices.add(0);
        for (int i = 0, j = 1; j < n; j++) {
            if (activities[i][1] <= activities[j][0]) {
                i = j;
                activitiesIndices.add(i);
            }
        }
        int activitiesCount = activitiesIndices.size();
        int[] indices = new int[activitiesCount];
        for (int i = 0; i < activitiesCount; i++) {
            indices[i] = activitiesIndices.get(i);
        }
        return indices;
    }

}