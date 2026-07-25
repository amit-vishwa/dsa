package module.one.maths.one.assignment;

/**
 * Excel Sheet Title: [Leetcode 168. Excel Sheet Column Title]
 * <p>
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 * <p>
 * Input 1: columnNumber = 1
 * Output 1: "A"
 * Explanation 1:
 * <p>
 * Input 2: columnNumber = 28
 * Output 2: "AB"
 * <p>
 * Constraints:
 * 1 <= columnNumber <= 231-1
 * <p>
 * Approach:
 * - A simple approach is to take mod of given number minus 1 by 26.
 * - Then also check if number is greater than 26, then divide number - 1 by 26.
 * - We are doing -1 as we are calculating the result by adding character 'A'.
 * - So here we require 0-based value.
 * - Time complexity: O(log26(N)) as it is divided by 26 so base 26 = O(log(N)) for base agnostic
 * - Space complexity: O(1), as no extra space is used. Space is only used for result which is not auxiliary space.
 */
public class _10ExcelSheetTitle {

    public static void main(String[] args) {
        System.out.println("Excel sheet title: " + getTitle(1));
        System.out.println("Excel sheet title: " + getTitle(28));
        System.out.println("Excel sheet title: " + getTitle(52));
        System.out.println("Excel sheet title: " + getTitle(53));
        System.out.println("Excel sheet title: " + getTitle(701));
    }

    private static String getTitle(int cell) {
        if (cell < 1) {
            return "";
        }
        StringBuilder title = new StringBuilder();
        while (cell > 0) {
            cell--;
            title.append((char) ('A' + cell % 26));
            cell /= 26;
        }
        return title.reverse().toString();
    }

}