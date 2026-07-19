package module.one.maths.two.lecture;

/**
 * Check if there is any subsequence that have gcd as 1.
 * Approaches:
 * 1. Bruteforce - Find all subsequences and check their gcd, Time complexity: O(2^n * nlogm),
 * here 2^n is for finding all subsequences, n is for iterating over array, log(m) is nothing but log(min(a,b))
 * which is the second-highest element in the array.
 * 2. Optimal - Find the gcd of whole array, if it is 1 then we got answer.
 */
public class GcdSubsequence {

    public static void main(String[] args) {
        System.out.println(gcdOneSubsequence(new int[]{4, 7, 9, 2, 10, 5}));
        System.out.println(gcdOneSubsequence(new int[]{4, 8, 20, 2, 10, 6}));
    }

    // Time complexity: O(N) array iteration * O(log(min(a,b))) gcd complexity = O(N*log(min(a,b)))
    private static boolean gcdOneSubsequence(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

    // Time and space complexity: O(log(min(a,b)))
    private static int gcd(int n1, int n2) {
        return n1 == 0 ? n2 : gcd(n2 % n1, n1);
    }

}
