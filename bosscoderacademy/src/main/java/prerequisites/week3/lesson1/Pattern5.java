package prerequisites.week3.lesson1;

/**
 * 5. Pascal’s Triangle Using Nested Loops
 *      1
 *     1 1
 *    1 2 1
 *   1 3 3 1
 *  1 4 6 4 1
 *
 * Pascal’s Triangle is a triangular arrangement of numbers. Each number is the sum of the two directly above it.
 * Refer YouTube for more information: youtube.com/watch?v=bR7mQgwQ_o8
 * */
public class Pattern5 {

    public static void main(String[] args) {
        printPattern(5);
    }

    static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            int res = 1;
            System.out.print(res + " ");
            for (int j = 1; j < i; j++) {
                res = res * (i - j) / j;
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }

}
