package module.one.recursion.one.lecture;

/**
 * Print increasing and decreasing order:
 *
 * The problem is a combination of problem print 1 to N and N to 1.
 * Time complexity: O(N) as we are simply printing before and after so same time taken here.
 * Space complexity: O(N) due to stack.
 */
public class PrintDecreasingIncreasing {

    public static void main(String[] args) {
        printIncreasingDecreasing(5);
    }

    private static void printIncreasingDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " "); // prints in decreasing order
        printIncreasingDecreasing(n - 1);
        System.out.print(n + " "); // prints in increasing order
    }

}
