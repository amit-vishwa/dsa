package module.two.greedy.assignment;

import java.util.Arrays;

// Refer _2MinimumPlatforms.java from package module.two.greedy.notes.
public class _2MinimumPlatforms {

    public static void main(String[] args) {
        System.out.println("Minimum number of platforms required is " + minimumPlatforms(new int[]{900, 940, 950, 1100, 1500, 1800},
                new int[]{910, 1200, 1120, 1130, 1900, 2000}));
        System.out.println("Minimum number of platforms required is " + minimumPlatforms(new int[]{900, 940}, new int[]{910, 1200}));
    }

    private static int minimumPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, platforms = 0, maxPlatforms = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                i++;
                platforms++;
            } else {
                j++;
                platforms--;
            }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }
        return maxPlatforms;
    }

}