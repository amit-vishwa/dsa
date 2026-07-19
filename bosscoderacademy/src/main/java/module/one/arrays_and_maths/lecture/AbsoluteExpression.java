package module.one.arrays_and_maths.lecture;

import java.util.Arrays;

/**
 * Find the max difference of absolute expression. [Leetcode 1131. Maximum of Absolute Value Expression]
 * <p>
 * We know that |a - b| means a > b to produce positive result.
 * And |b - a| means b > a for a positive result, thus applying the same in below expressions.
 * <p>
 * Expression 1: |arr[i] - arr[j]| + |i - j|
 * Case 1: arr[i] > arr[j] & i > j
 * arr[i] - arr[j] + i - j
 * arr[i] + i - arr[j] - j
 * (arr[i] + i) - (arr[j] + j)
 * i.e. X - Y, max - min
 * <p>
 * Case 2: arr[i] < arr[j] & i > j
 * arr[j] - arr[i] + i - j
 * arr[j] - j + i - arr[i]
 * - arr[j] + j - i + arr[i]
 * arr[i] - i - arr[j] + j
 * (arr[i] - i) - (arr[j] - j)
 * i.e. X - Y, max - min
 * <p>
 * Rest cases for i < j with arr[i] > arr[j] and i < j with arr[i] < arr[j] can be ignored,
 * as i and j both are indices and can be interchangeably used by providing same output.
 * So only one case i > j can be considered which we already did.
 * <p>
 * Expression 2: |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i-j|
 * Case 1: arr1[i] > arr1[j] and arr2[i] > arr2[j] & i > j
 * arr1[i] - arr1[j] + arr2[i] - arr2[j] + i - j
 * arr1[i] + arr2[i] + i - arr1[j] - arr2[j] - j
 * (arr1[i] + arr2[i] + i) - (arr1[j] + arr2[j] + j)
 * i.e. X - Y, max - min
 * <p>
 * Case 2: arr1[i] < arr1[j] and arr2[i] > arr2[j] & i > j
 * arr1[j] - arr1[i] + arr2[i] - arr2[j] + i - j
 * arr2[i] - arr1[i] + i + arr1[j] - arr2[j] - j
 * arr2[i] - arr1[i] + i - arr2[j] + arr1[j] - j
 * (arr2[i] - arr1[i] + i) - (arr2[j] - arr1[j] + j)
 * i.e. X - Y, max - min
 * <p>
 * Case 3: arr1[i] > arr1[j] and arr2[i] < arr2[j] & i > j
 * arr1[i] - arr1[j] + arr2[j] - arr2[i] + i - j
 * arr1[i] - arr2[i] + i - arr1[j] + arr2[j] - j
 * (arr1[i] - arr2[i] + i) - (arr1[j] - arr2[j] + j)
 * i.e. X - Y, max - min
 * <p>
 * Case 4: arr1[i] < arr1[j] and arr2[i] < arr2[j] & i > j
 * arr1[j] - arr1[i] + arr2[j] - arr2[i] + i - j
 * arr1[j] + arr2[j] - j - arr1[i] - arr2[i] + i
 * i - arr1[i] - arr2[i] - j + arr1[j] + arr2[j]
 * (i - arr1[i] - arr2[i]) - (j - arr1[j] - arr2[j])
 * i.e. X - Y, max - min
 * <p>
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
public class AbsoluteExpression {

    public static void main(String[] args) {
        printMaxDiff(new int[]{1, 2, 3, 4}, new int[]{-1, 4, 5, 6});
        printMaxDiff(new int[]{1, -2, -5, 0, 10}, new int[]{0, -2, -1, -7, -4});
    }

    private static void printMaxDiff(int[] arr1, int[] arr2) {
        int maxC1 = Integer.MIN_VALUE, minC1 = Integer.MAX_VALUE;
        int maxC2 = Integer.MIN_VALUE, minC2 = Integer.MAX_VALUE;
        int maxC3 = Integer.MIN_VALUE, minC3 = Integer.MAX_VALUE;
        int maxC4 = Integer.MIN_VALUE, minC4 = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            int c1 = arr1[i] + arr2[i] + i;
            maxC1 = Math.max(maxC1, c1);
            minC1 = Math.min(minC1, c1);
            int c2 = arr2[i] - arr1[i] + i;
            maxC2 = Math.max(maxC2, c2);
            minC2 = Math.min(minC2, c2);
            int c3 = arr1[i] - arr2[i] + i;
            maxC3 = Math.max(maxC3, c3);
            minC3 = Math.min(minC3, c3);
            int c4 = i - arr1[i] - arr2[i];
            maxC4 = Math.max(maxC4, c4);
            minC4 = Math.min(minC4, c4);
//            System.out.println(i + " [ C1: " + c1 + ", C2: " + c2 + ", C3: " + c3 + ", C4: " + c4 + " ]");
        }
        int maxDiff = Math.max(Math.max(maxC1 - minC1, maxC2 - minC2), Math.max(maxC3 - minC3, maxC4 - minC4));
        System.out.println("Array1: " + Arrays.toString(arr1));
        System.out.println("Array2: " + Arrays.toString(arr2));
        System.out.println("Maximum difference: " + maxDiff);
    }

}
