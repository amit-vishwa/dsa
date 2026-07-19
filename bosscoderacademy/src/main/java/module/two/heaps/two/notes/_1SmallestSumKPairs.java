package module.two.heaps.two.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// Refer _2SmallestSumKPairs.java from package module.two.heaps.one.assignment.
public class _1SmallestSumKPairs {

    public static void main(String[] args) {
        printKPairsSmallestSums(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
    }

    private static void printKPairsSmallestSums(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minPQ = new PriorityQueue<>((arr1, arr2) -> (arr1[0] + arr1[1]) - (arr2[0] + arr2[1]));
        List<List<Integer>> listOfList = new ArrayList<>();
        boolean flag = false;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                minPQ.add(new int[]{num1, num2});
                if (minPQ.size() > k) {
                    listOfList.add(Arrays.stream(minPQ.remove()).boxed().toList());
                    if (listOfList.size() == k) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(k + " pairs with smallest sums are " + listOfList);
    }

}
