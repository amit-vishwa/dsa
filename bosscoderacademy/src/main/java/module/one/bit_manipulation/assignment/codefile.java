package module.one.bit_manipulation.assignment;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;

public class codefile {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(17)));
        System.out.println(Arrays.toString(solve(2)));
    }

    static int[] solve(int n) {
        int even = 0, odd = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((n & mask) > 0) {
                if ((i & 1) == 1) {
                    odd++;
                } else {
                    even++;
                }
            }
        }
        return new int[]{even, odd};
    }

}
