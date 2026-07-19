package module.one.arrays_and_maths.warmup;

// Leetcode 412. Fizz Buzz
public class _1FizzBuzz {

    public static void main(String[] args) {
        solve(10);
        solve(15);
    }

    private static void solve(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz,");
            } else if (i % 3 == 0) {
                System.out.print("Fizz,");
            } else if (i % 5 == 0) {
                System.out.print("Buzz,");
            } else {
                System.out.print(i + ",");
            }
        }
        System.out.println();
    }

}