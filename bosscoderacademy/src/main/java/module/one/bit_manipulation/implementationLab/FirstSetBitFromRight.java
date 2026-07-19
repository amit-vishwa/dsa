package module.one.bit_manipulation.implementationLab;

/**
 * First set bit from right:
 * - Here, we have to find the first set bit from right side i.e. LSB side.
 *
 * Example: N = 104
 * Binary = 0 1 1 0  1 0 0 0
 * So, here we can count from RHS i.e. LSB and see that 1 is first occurred at position 4 i.e. index 3.
 * Thus, we are getting 4 as answer as per 1 based indexing.
 * Time and space complexity is constant.
 * */
public class FirstSetBitFromRight {

    public static void main(String[] args) {
        System.out.println(firstSetBitPosition(104));
    }

    private static int firstSetBitPosition(int n) {
        int count = 1; // 1 based indexing
        while (n > 0) {
            if ((n & 1) != 0) {
                return count;
            }
            n >>>= 1;
            count++;
        }
        return -1;
    }

}
