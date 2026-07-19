package module.two.greedy.notes;

import java.util.Arrays;

/**
 * N meetings in one room:
 * <p>
 * There is one meeting room in the firm. There are N meetings in the form of (start[i], end[i]) where start[i] is the start
 * time of meeting i and end[i] is the finish time of meeting i.
 * What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the
 * meeting room at a particular time?
 * <p>
 * Example
 * Input: N = 6 start[] = {1,3,0,5,8,5} end[] =  {2,4,6,7,9,9}
 * Output: 4
 * <p>
 * Approach: Refer _1ActivitySelection.java from package module.two.greedy.lecture.
 */
public class _1NMeetings {

    public static void main(String[] args) {
        System.out.println("Maximum meetings can be accommodated in one room is " + maxMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}));
    }

    private static int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, (meet1, meet2) -> (meet1[1] == meet2[1]) ? meet1[0] - meet2[0] : meet1[1] - meet2[1]);
        int maxMeetings = 1;
        for (int i = 0, j = 1; j < n; j++) {
            if (meetings[i][1] <= meetings[j][0]) {
                i = j;
                maxMeetings++;
            }
        }
        return maxMeetings;
    }

}
