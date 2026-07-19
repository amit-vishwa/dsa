package module.one.exams.two;

/**
 * Refer _5TrailingZero.java file from module.one.bit_manipulation.assignment package.
 */
public class _2CountTrailingZeroes {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(12));
        System.out.println(trailingZeroes(-56));
    }

    private static int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                return count;
            }
            count++;
            n >>>= 1;
        }
        return count;
    }

}
