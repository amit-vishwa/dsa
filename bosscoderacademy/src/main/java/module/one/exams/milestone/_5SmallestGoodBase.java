package module.one.exams.milestone;

/**
 * Refer SmallestGoodBase.java file from package module.one.searching.implementationLab.
 */
public class _5SmallestGoodBase {

    public static void main(String[] args) {
        System.out.println(smallestGoodBase(13));
        System.out.println(smallestGoodBase(4681));
        System.out.println(smallestGoodBase(1000000000));
    }

    private static int smallestGoodBase(int num) {
        for (int bit = 64; bit >= 2; bit--) {
            int start = 2, end = num - 1;
            while (start <= end) {
                int base = start + (end - start) / 2;
                int lhs = num * (base - 1);
                int rhs = (int) Math.pow(base, bit) - 1;
                if (lhs == rhs) {
                    return base;
                }
                if (lhs < rhs) {
                    end = base - 1;
                } else {
                    start = base + 1;
                }
            }
        }
        return num - 1;
    }

}
