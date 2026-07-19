package module.one.bit_manipulation.implementationLab;

/**
 * First set bit from left:
 * - Here, we have to find the first set bit from left side i.e. MSB side.
 * <p>
 * Example: N = 105
 * Binary = 0 1 1 0  1 0 0 1
 * So, here we can count from LHS i.e. MSB and see that 1 is first occurred at position 2 i.e. index 1 in byte data type.
 * Thus, we are getting 2 as answer as per 1 based indexing.
 * Time and space complexity is constant.
 */
public class FirstSetBitFromLeft {

    public static void main(String[] args) {
        System.out.println(firstSetBitPosition((byte) 105));
    }

    private static int firstSetBitPosition(byte n) {
        int count = 1;
        for (byte i = 7; i >= 0; i--) {
            byte mask = (byte) (1 << i);
            if ((n & mask) != 0) {
                return count;
            }
            count++;
        }
        return -1;
    }
}
