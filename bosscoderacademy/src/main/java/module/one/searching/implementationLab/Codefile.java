package module.one.searching.implementationLab;

public class Codefile {

    public static void main(String[] args) {
        printGoodBase("13");
        printGoodBase("4681");
        printGoodBase("1000000000000000000");
    }

    private static void printGoodBase(String num) {
//        System.out.println("Smallest good base by approach 1: " + approach1(num));
        System.out.println("Smallest good base by approach 2: " + approach2(num));
        System.out.println("Smallest good base by approach 3: " + approach3(num));
        System.out.println();
    }

    private static String approach1(String num) {
        long number = Long.parseLong(num);
        for (long n = 2; n < number; n++) {
            long digit = 63;
            long x = n, res = 1;
            while (digit > 0) {
                res += x;
                if (res == number) {
                    return String.valueOf(n);
                }
                if (res > number) {
                    break;
                }
                x *= n;
                digit--;
            }
        }
        return String.valueOf(number - 1);
    }

    private static String approach2(String n) {
        long num = Long.parseLong(n);
        for (int bit = 63; bit >= 2; bit--) {
            long low = 2, high = num - 1;
            while (low <= high) {
                long base = low + (high - low) / 2;
                long lhs = (long) Math.pow(base, bit) - 1;
                long rhs = num * (base - 1);
                if (lhs == rhs) {
                    return String.valueOf(base);
                }
                if (lhs < rhs) {
                    low = base + 1;
                } else {
                    high = base - 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }

    private static String approach3(String n) {
        long num = Long.parseLong(n);
        for (int bit = 60; bit >= 1; bit--) {
            long low = 2;
            long high = (long) Math.pow(num, 1.0 / bit);
            while (low <= high) {
                long base = low + (high - low) / 2;
                long sum = 1;
                long cur = 1;
                boolean overflow = false;
                for (int i = 1; i <= bit; i++) {
                    if (cur > num / base) {
                        overflow = true;
                        break;
                    }
                    cur *= base;
                    if (sum > num - cur) {
                        overflow = true;
                        break;
                    }
                    sum += cur;
                }
                if (!overflow && sum == num) {
                    return String.valueOf(base);
                }
                if (overflow || sum > num) {
                    high = base - 1;
                } else {
                    low = base + 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }

}