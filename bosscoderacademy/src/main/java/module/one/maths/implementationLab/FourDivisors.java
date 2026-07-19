package module.one.maths.implementationLab;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array, check each element and return the sum of its factors if factor count is 4 exactly.
 * Approaches:
 * 1. Bruteforce - simply iterate over array, find all factors for an element, check if list size is 4 then add them cumulatively.
 * 2. Better solution - complexity here is similar to bruteforce but number of operations are reduced, count while getting
 * factors do this till if count exceeds 4 or reached till square root of number, return sum if only count is 4 else 0.
 */
public class FourDivisors {

    public static void main(String[] args) {
        printSum(new int[]{21, 4, 7});
        printSum(new int[]{21, 21});
    }

    private static void printSum(int[] arr) {
        System.out.println("Four factors sum by approach1: " + approach1(arr));
        System.out.println("Four factors sum by approach2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - Here iterate over the array and find all factors for each element.
     * - Store them in a list and count list size, if it is exactly 4 then add them cumulatively.
     * - Else simple return 0.
     * - Time complexity: O(N) array iteration * O(sqrt(M)) finding factors = O(N*sqrt(M))
     * - Space complexity: O(M), to store factors of number
     */
    private static int approach1(int[] arr) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    list.add(i);
                    if (i != num / i) {
                        list.add(num / i);
                    }
                }
            }
            if (list.size() == 4) {
                for (int n : list) {
                    sum += n;
                }
            }
            list.clear();
        }
        return sum;
    }

    /**
     * Approach 2 - Better Bruteforce approach
     * - This approach will take time complexity similar to above Bruteforce approach, however space complexity is constant.
     * - In this approach, we have to take one counter and one sum variable.
     * - Iterate over the array, find the factors of each element.
     * - When i divides num, then first check whether i * i == num, i.e. if num is perfect square, it is return 0 from there.
     * - This won't impact much but it will save 3 lines of code operations.
     * - While finding factors, do the cumulative and ensure that count is not getting exceeded after 4.
     * - At last, return the sum only if count is 4, else return 0;
     * - Time complexity: O(N) for array iteration * O(sqrt(M)) for finding factors = O(N*sqrt(M))
     * - Space complexity: O(1), no extra space is used
     */
    private static int approach2(int[] arr) {
        int sum = 0;
        for (int num : arr) { // O(N)
            sum += contributions(num);
        }
        return sum;
    }

    private static int contributions(int num) {
        int count = 0, sum = 0;
        for (int i = 1; i * i <= num && count <= 4; i++) { // O(sqrt(M))
            if (num % i == 0) {
                // this means, num is perfect square and it always had odd factors
                if (i * i == num) { // won't impact much if not added
                    return 0;
                }
                count = (i != num / i) ? count + 2 : count + 1;
                sum = sum + i + num / i;
            }
        }
        return count == 4 ? sum : 0;
    }

}
