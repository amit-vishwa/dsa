package module.one.sorting.two.assignment;

import java.util.ArrayList;
import java.util.List;

public class codefile {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<List<Integer>>(List.of(new ArrayList<>(List.of(1, 3)),
                new ArrayList<>(List.of(-2, 2)))), 1));
    }

    public static List<List<Integer>> solve(List<List<Integer>> input, int k) {
        int n = input.size();
        for (int i = 1; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i; j++) {
                int num1 = (input.get(j).get(0) * input.get(j).get(0)) + (input.get(j).get(1) * input.get(j).get(1));
                int num2 = (input.get(j + 1).get(0) * input.get(j + 1).get(0)) + (input.get(j + 1).get(1) * input.get(j + 1).get(1));
                if (num1 > num2) {
                    List<Integer> temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println(input);
        List<List<Integer>> ans = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            ans.add(input.get(i));
        }
        return ans;
    }
}