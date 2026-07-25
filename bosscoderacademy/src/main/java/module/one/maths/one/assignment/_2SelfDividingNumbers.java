package module.one.maths.one.assignment;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Self Dividing Numbers: [Leetcode 728. Self Dividing Numbers]
 * <p>
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * <p>
 * A self-dividing number is not allowed to contain the digit zero.
 * Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].
 * <p>
 * Input: left = 1, right = 22
 * Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
 * <p>
 * Input: left = 47, right = 85
 * Output: [48,55,66,77]
 * <p>
 * Constraints:
 * 1 <= left <= right <= 104
 * <p>
 * Approach:
 * - Simple approach is to iterate from start number to end number and check if number is a self diving number.
 * - For self dividing number check always use temp variable and check divisibility with original number.
 * - Time complexity: O(N) iteration from start to end * O(maxNumDigitCount) max number digit count = O(N*maxNumDigitCount)
 * - Space complexity: O(N) as we are taking extra space to store in a list and then returning in an array.
 */
public class _2SelfDividingNumbers {

    public static void main(String[] args) {
        System.out.println("Self dividing numbers: " + Arrays.toString(selfDividingNumbers(1, 22)));
        System.out.println("Self dividing numbers: " + Arrays.toString(selfDividingNumbers(47, 85)));
    }

    private static int[] selfDividingNumbers(int left, int right) {
        ArrayList<Integer> selfDividingNumberList = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (isSelfDividingNumber(num)) {
                selfDividingNumberList.add(num);
            }
        }
        int[] selfDividingNumberArray = new int[selfDividingNumberList.size()];
        for (int i = 0; i < selfDividingNumberList.size(); i++) {
            selfDividingNumberArray[i] = selfDividingNumberList.get(i);
        }
        return selfDividingNumberArray;
    }

    private static boolean isSelfDividingNumber(int number) {
        int num = number;
        while (num > 0) {
            int remainder = num % 10;
            if (remainder == 0 || number % remainder != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

}