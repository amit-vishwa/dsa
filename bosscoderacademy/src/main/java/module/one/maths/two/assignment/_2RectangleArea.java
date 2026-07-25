package module.one.maths.two.assignment;

/**
 * Rectangle Area: [Leetcode 223. Rectangle Area]
 * <p>
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
 * <p>
 * Input 1: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * Output 1: 45
 * Explanation 1:
 * <p>
 * Input 2: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * Output 2: 16
 * <p>
 * Constraints:
 * -104 <= ax1 <= ax2 <= 104
 * -104 <= ay1 <= ay2 <= 104
 * -104 <= bx1 <= bx2 <= 104
 * -104 <= by1 <= by2 <= 104
 * <p>
 * Approach:
 * - The simple approach is to find area of rectangle 1 and then area of rectangle 2.
 * - Calculate the common rectangle are and reduce it from the sum of areas of rectangle 1 and 2.
 * - To find length and breath of rectangles 1 and 2 check if only any one of coordinate is negative them subtract them,
 * else just add them to get the values, also get their absolute values as area cannot be in negative.
 * - Now, to find length of common rectangle get absolute difference of max of ax2,bx2 and ax1,bx1 where a and b are rectangles.
 * - Also, do the same with y coordinates to find the breadth, and after finding both calculate the area.
 * - Space and time complexity: O(1) as it is simple computational operations.
 */
public class _2RectangleArea {

    public static void main(String[] args) {
        printRectangleArea(-3, 0, 3, 4, 0, -1, 9, 2);
        printRectangleArea(-2, -2, 2, 2, -2, -2, 2, 2);
    }

    private static void printRectangleArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int l1 = ax2 - ax1;
        int b1 = ay2 - ay1;
        int a1 = l1 * b1;
        System.out.println("Rectangle 1 : [Length: " + l1 + ", Breadth: " + b1 + ", Area: " + a1 + "]");

        int l2 = bx2 - bx1;
        int b2 = by2 - by1;
        int a2 = l2 * b2;
        System.out.println("Rectangle 2 : [Length: " + l2 + ", Breadth: " + b2 + ", Area: " + a2 + "]");

        int l3 = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int b3 = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int a3 = l3 * b3;
        System.out.println("Rectangle 3 (common): [Length: " + l3 + ", Breadth: " + b3 + ", Area: " + a3 + "]");

        int totalArea = a1 + a2 - a3; // reduce a3 as it is calculated twice
        System.out.println("Total area covered by rectangle is " + totalArea + " square units\n");
    }

}