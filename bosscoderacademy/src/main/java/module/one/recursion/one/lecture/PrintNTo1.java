package module.one.recursion.one.lecture;

/**
 * Print numbers from N to 1:
 * <p>
 * We have to print first then traverse up the stack.
 * This will print the number in decreasing order.
 * Time complexity: O(N) as we are iterating till N.
 * Space complexity: O(N) due to stack memory.
 */
public class PrintNTo1 {

    public static void main(String[] args) {
        printNTo1(5);
    }

    private static void printNTo1(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printNTo1(n - 1);
    }

}
