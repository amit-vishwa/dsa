package module.one.maths.one.assignment;

/**
 * Rectangle Overlap: [Leetcode 836. Rectangle Overlap]
 * <p>
 * An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left
 * corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis,
 * and its left and right edges are parallel to the Y-axis. Two rectangles overlap if the area of their intersection is
 * positive. To be clear, two rectangles that only touch at the corner or edges do not overlap. Given two axis-aligned
 * rectangles rec1 and rec2, return true if they overlap, otherwise return false.
 * <p>
 * Input 1: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output 1: true
 * Explanation 1: Both the rectangles overlap each other.
 * <p>
 * Input 2: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output 2: false
 * <p>
 * Constraints:
 * -108 <= rec1[i], rec2[i] <= 108
 * rec1 and rec2 represent a valid rectangle with a non-zero area.
 * <p>
 * Approach:
 * - The approach is simple here.
 * - We just have to check the bottomLeft coordinates of left rectangle or rectangle one should be less than the topRight
 * coordinates of right or second rectangle.
 * - Similarly, the topRight coordinates of first rectangle should be greater than the bottomLeft coordinates of the
 * second rectangle.
 * - Time and space complexity is O(1).
 */
public class _9RectangleOverlap {

    public static void main(String[] args) {
        System.out.println("Are rectangles overlapping? " + areOverlappingRectangles(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println("Are rectangles overlapping? " + areOverlappingRectangles(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
        System.out.println("Are rectangles overlapping? " + areOverlappingRectangles(new int[]{0, 0, 1, 1}, new int[]{2, 2, 3, 3}));
    }

    private static boolean areOverlappingRectangles(int[] rec1, int[] rec2) {
        return (rec1[0] < rec2[2] && rec1[1] < rec2[3] && rec1[2] > rec2[0] && rec1[3] > rec2[1]);
    }

}