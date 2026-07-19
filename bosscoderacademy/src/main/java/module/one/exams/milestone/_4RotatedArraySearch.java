package module.one.exams.milestone;

/**
 * Refer _3RotatedSortedArray.java file from package module.one.exams.two.
 */
public class _4RotatedArraySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{1}, 0));
    }

    private static int search(int[] arr, int t) {
        int n = arr.length, s = 0, e = n - 1;
        int p = pivot(arr, s, e);
        if (p == -1 || arr[p] == t) {
            return p;
        }
        if (t >= arr[s] && p > 0 && t <= arr[p - 1]) {
            return binarySearch(arr, s, p - 1, t);
        }
        return binarySearch(arr, p, e, t);
    }

    private static int pivot(int[] arr, int s, int e) {
        while (s < e) {
            int m = s + (e - s) / 2;
            if (arr[m] <= arr[e]) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return e;
    }

    private static int binarySearch(int[] arr, int s, int e, int t) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] == t) {
                return m;
            }
            if (arr[m] < t) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }

}
