package prerequisites.week3.lesson1;

import java.util.Arrays;

/**
 * Perform operations on Pascal’s Triangle:
 *      1
 *     1 1
 *    1 2 1
 *   1 3 3 1
 *  1 4 6 4 1
 *
 * Pascal’s Triangle is a triangular arrangement of numbers. Each number is the sum of the two directly above it.
 * Refer YouTube for more information: youtube.com/watch?v=bR7mQgwQ_o8
 * */
public class PascalsTriangle {

    public static void main(String[] args) {
        printElement(0,0);
        printElement(2,1);
        printElement(4,2);
        printElement(3,2);

        printPascalRow(5);
        printPascalRow(6);

        printPattern(5);
    }

    /**
     * Given row and column, print the element at that place from Pascal's triangle.
     * Formula: n! / r! * (n - r)! , here n is row and r is column
     * Simple formula is to find factorial till r i.e. column here.
     *
     * Time complexity: O(r), Space complexity: O(1)
     */
    static void printElement(int r, int c) {
        long res = 1;
        // 0 based row column access
        for (int i = 0; i < c; i++) { // iterate till column i.e. r! only to reduce complexity
            res = res * (r - i); // this n * (n-1) * (n-2) * r!
            res = res / (i + 1); // this is divide by r! i.e. for 3! it is 1*2*3
        }
        System.out.printf("Element at row %d, column %d in Pascal's triangle is %d\n", r, c, res);
    }

    /**
     * Print a row of the Pascal's triangle.
     * An approach could be iterated till the specified column by calling above method.
     * But here time complexity will be O(n*r), where r is col and n will be row number.
     * We can optimize it more by finding the pattern and calculating the formula.
     * Refer for implementation and formula: http://youtube.com/watch?v=bR7mQgwQ_o8
     *
     * Time complexity: O(N), here N is number of row
     * Space complexity: O(1)
     * */
    static void printPascalRow(int n) {
        int res = 1;
        int[] arr = new int[n];
        arr[0] = res;
        for (int i = 1; i < n; i++) { // 0 based indexing for rows
            res = res * (n - i) / i; // it finds the element at particular column of specified row
            arr[i] = res;
        }
        System.out.println("Pascal's " + n + "th row is " + Arrays.toString(arr));
    }

    /**
     * Time complexity: O(N * R), here N is total rows, R is current row number
     * Space complexity: O(1)
     * */
    static void printPattern(int n) {
        int[][] arr = new int[n][];
        for (int i = 1; i <= n; i++) {
            // printing spaces on left side
            for (int j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }
            int[] ar = new int[i];
            int res = 1;
            ar[0] = res;
            // first element is always 1
            System.out.print(res + " ");
            // calculating and printing other elements
            for (int j = 1; j < i; j++) {
                // element calculation logic is similar to method printPascalRow()
                res = res * (i - j) / j;
                ar[j] = res;
                System.out.print(res + " ");
            }
            System.out.println();
            arr[i - 1] = ar;
        }
        System.out.println("Pascal's triangle: " + Arrays.deepToString(arr));
    }

}
