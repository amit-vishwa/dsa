package module.one.sorting.two.notes;

import java.util.Arrays;

/**
 * Lock and Key Problem:
 * <p>
 * Given a box with locks and keys where one lock can be opened by one key in the box. We need to match the pair.
 * <p>
 * Example
 * Input:
 * The lists of locks and keys.
 * nuts = { ),@,*,^,(,%, !,$,&,#}
 * bolts = { !, (, #, %, ), ^, &, *, $, @ }
 * <p>
 * Output:
 * After matching nuts and bolts:
 * Nuts:  ! # $ % & ( ) * @ ^
 * Bolts: ! # $ % & ( ) * @ ^
 * <p>
 * Approach
 * This problem is solved by the quick-sort technique. By taking the last element of the bolt as a pivot, rearrange the nuts
 * list and get the final position of the nut whose bolt is the pivot element. After partitioning the nuts list, we can
 * partition the bolts list using the selected nut. The same tasks are performed for left and right sub-lists to get all matches.
 * In short, just perform the simple quick sort with char type elements.
 * <p>
 * Time Complexity: O(N*logN) similar to quick sort
 * Space Complexity: O(1) similar to quick sort
 */
public class _3LockAndKey {

    public static void main(String[] args) {
        sort(new char[]{')', '@', '*', '^', '(', '%', '!', '$', '&', '#'});
        sort(new char[]{'!', '(', '#', '%', ')', '^', '&', '*', '$', '@'});
    }

    private static void sort(char[] box) {
        System.out.println("Box: " + Arrays.toString(box));
        quickSort(box, 0, box.length - 1);
        System.out.println("Sorted Box: " + Arrays.toString(box) + "\n");
    }

    private static void quickSort(char[] box, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = partition(box, start, end);
        quickSort(box, start, pivot - 1);
        quickSort(box, pivot + 1, end);
    }

    private static int partition(char[] box, int start, int end) {
        int i = start, j = start, pivot = box[end];
        while (i <= end) {
            if (box[i] <= pivot) {
                swap(box, i++, j++);
            } else {
                i++;
            }
        }
        return j - 1;
    }

    private static void swap(char[] box, int i, int j) {
        char temp = box[i];
        box[i] = box[j];
        box[j] = temp;
    }

}
