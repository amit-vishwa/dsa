package module.one.exams.mock;

// Refer: https://leetcode.com/problems/find-peak-element/description/?envType=problem-list-v2&envId=binary-search
public class _1FindPeakElement {

    public static void main(String[] args) {
        System.out.println("Peak element index: " + peakElementIndex(new int[]{1, 2, 3, 1}));
        System.out.println("Peak element index: " + peakElementIndex(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    private static int peakElementIndex(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (m < e && nums[m] > nums[m + 1]) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return e;
    }

}
