package module.one.bit_manipulation.implementationLab;

/**
 * Single Number I:
 * <p>
 * Every number is present twice, only one number is present once, find that number.
 * Refer: _3SingleNumber.java file from notes for more details and approaches as we are using most optimal approach here.
 */
public class SingleNumberI {

    public static void main(String[] args) {
        System.out.println(distinctNumber(new int[]{0, 10, 2, 2, 0}));
    }

    // Time complexity: O(N), Space complexity: O(1)
    private static int distinctNumber(int[] arr) {
        int res = 0;
        for (int n : arr) {
            res ^= n;
        }
        return res;
    }

}
