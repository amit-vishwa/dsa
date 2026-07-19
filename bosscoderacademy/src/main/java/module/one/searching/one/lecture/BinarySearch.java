package module.one.searching.one.lecture;

/**
 * Binary search:
 * - The algorithm consist of searching the given target in the array.
 * - We have to reduce the search space by half after each pass.
 * - This algorithm only works on sorted array, so it check if target is less or greater than mid-element.
 * - Then accordingly it checks in left or right part of the array.
 * - If target found then returns the index.
 * - Time complexity: O(logN) as search space is getting reduced by half i.e. base is 2 here.
 * - Space complexity: O(1) as it does not require any extra space.
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 3));
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 31));
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 72));
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 2));
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 1));
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 75));
    }

    private static int searchTarget(int[] arr, int t) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == t) {
                return m;
            }
            if (arr[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

}
