package module.one.recursion.one.lecture;

/**
 * Print numbers from 1 to N:
 * <p>
 * We have to first traverse up the stack, then while coming down we can print the number.
 * This will print the number in increasing order.
 * Time complexity: O(N) as we are iterating till N.
 * Space complexity: O(N) due to stack memory.
 */
public class Print1ToN {

    public static void main(String[] args) {
        print1ToN(5);
    }

    private static void print1ToN(int n) {
        if (n == 0) {
            return;
        }
        print1ToN(n - 1);
        System.out.print(n + " ");
    }

}
