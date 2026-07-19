package module.one.maths.one.notes;

/**
 * Subsequence with gcd 1:
 * Given an array find if there is a subsequence with gcd 1 if it is not there print -1 else print 1.
 *
 * Approach
 * If there is any subsequence with gcd 1 then the gcd of the whole array will be 1 so find the gcd of the
 * whole array if it is 1 then return 1 else return -1.
 * */
public class _5Gcd1Subsequence {

    public static void main(String[] args) {
        gcd1Subsequence(new int[]{2, 5, 6, 9, 10});
        gcd1Subsequence(new int[]{3, 3});
    }

    /**
     * Approach:
     * - Same approach as Gcd of array, only here added condition if array gcd is 1 then print 1 else -1.
     * - Time and space complexities are same i.e. O(N * log(M)), N - arr length, M - second-highest number.
     * */
    private static void gcd1Subsequence(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length && result != 1; i++) {
            result = gcd(result, arr[i]);
        }
        System.out.println((result == 1) ? 1 : -1);
    }

    // Time & space complexity: O(log(min(a,b)))
    private static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

}