package prerequisites.week4.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSortCounter {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{64, 34, 25, 12, 22, 11, 90}));
        System.out.println(solve(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    static Pair<List<Integer>, Integer> solve(int[] input) {
        List<Integer> list = new ArrayList<>();
        for (int n : input) {
            list.add(n);
        }
        int comparisons = 0;
        for (int i = 0; i < input.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < input.length; j++) {
                if (list.get(min) > list.get(j)) {
                    min = j;
                }
                comparisons++;
            }
            if (min != i) {
                int temp = list.get(min);
                list.set(min, list.get(i));
                list.set(i, temp);
            }
        }
        System.out.println("Array: " + Arrays.toString(input));
        System.out.println("Sorted Array: " + list);
        System.out.println("Comparisons: " + comparisons);
        return new Pair<>(list, comparisons);
    }

}
