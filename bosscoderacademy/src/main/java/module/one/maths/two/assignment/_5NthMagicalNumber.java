package module.one.maths.two.assignment;

/**
 * Nth Magical Number:
 * <p>
 * A positive integer is magical if it is divisible by either a or b.
 * <p>
 * Given the three integers n, a, and b, return the nth magical number. Since the answer may be very large, return it
 * modulo 10^9 + 7.
 * <p>
 * Input: n = 1, a = 2, b = 3
 * Output: 2
 * <p>
 * Input: n = 4, a = 2, b = 3
 * Output: 6
 * <p>
 * Constraints:
 * 1 <= n <= 109
 * 2 <= a, b <= 4 * 104
 */
public class _5NthMagicalNumber {

    public static void main(String[] args) {
        printNthMagicalNumber(1, 2, 3);
        printNthMagicalNumber(4, 2, 3);
        printNthMagicalNumber(1000000000, 2, 3);
    }

    private static void printNthMagicalNumber(int n, int a, int b) {
//        System.out.println(n + "th magical number by approach 1: " + approach1(n, a, b));
        System.out.println(n + "th magical number by approach 2: " + approach2(n, a, b));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This is simple bruteforce approach, where we start from min of both given numbers.
     * - We also set a counter starting from 1 as 1st number is min of both so divisible by min only.
     * - Now will start a loop where counter is less than N, will increment number and check for divisibility.
     * - If divisible by anyone number then increment the counter, else iterate without increment.
     * - Repeat the process until counter == N.
     * - Then at last, return the number.
     * - The approach is simple however it won't work for large numbers where N is high.
     * - Time complexity: O(N), as we are iterating till N times to get Nth magical number.
     * - Space complexity: O(1), as we are not using any extra space.
     */
    private static int approach1(int n, int a, int b) {
        int count = 1;
        int num = Math.min(a, b);
        while (count < n) {
            num++;
            if (num % a == 0 || num % b == 0) {
                count++;
            }
        }
        return num;
    }

    /**
     * Approach 2 - Optimal approach
     * - This is the most optimal solution for this problem.
     * - Since we are iterating from min of given numbers, and then increasing the number.
     * - Here, we can observe that the numbers will always be sorted, so definitely binary search can be used as we are searching.
     * - Now, take lower bound as min of both numbers, and take upper bound as lower * N.
     * - As in worst case we will have numbers Nth magical when we reach lower * Nth number.
     * - Now, here we can proceed with the Binary search process and find the mid.
     * - After getting mid, we can divide it by numbers to check how many numbers are there before mid that are divisible by them.
     * - We can add them, but here we will be having repeating numbers count as well.
     * - So, for this we can reduce the common repeating numbers count by dividing mid by lcm of both numbers.
     * - Now, whatever the result we get we can decide based on that by comparing with N.
     * - If result is less than N, then update lower bound to mid+1, else update higher bound to mid only.
     * - Also, in while loop the condition is until lower is less than upper, as we are taking higher as mid so cannot add
     * lower<=higher in while loop condition as at the end they both will be equal only.
     * - Now, at last return any one lower or higher bound by taking the integer value of mod of 10^9+1.
     */
    private static int approach2(int n, int a, int b) {
        long low = Math.min(a, b);
        long high = low * n;
        while (low < high) {
            long mid = low + (high - low) / 2;
            long num = (mid / a) + (mid / b) - (mid / lcm(a, b));
            if (num < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int) (high % ((int) Math.pow(10, 9) + 7));
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        while (a > 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

}