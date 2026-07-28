package module.one.searching.implementationLab;

/**
 * Find the index of the element: [Leetcode 162. Find Peak Element]
 * <p>
 * A peak element is an element which is greater than its neighbours.
 * So any element that is greater than its left and right neighbours is called as a peak element.
 * There can be multiple peak elements, so return the index of any one.
 * <p>
 * Example: arr = [1,2,1,3,5,6,4], ans = 1 or 5 i.e. element 2 or 6
 * <p>
 * Refer: _3PeakElement.java from module.one.searching.one.notes package.
 */
public class PeakElement {

    public static void main(String[] args) {
        printPeakIndex(new int[]{1, 2, 1, 3, 5, 6, 4});
    }

    private static void printPeakIndex(int[] arr) {
        System.out.println("Peak index by approach 1: " + approach1(arr));
        System.out.println("Peak index by approach 2: " + approach2(arr));
        System.out.println();
    }

    private static int approach1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return n == 0 ? -1 : n - 1;
    }

    private static int approach2(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > arr[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

}
