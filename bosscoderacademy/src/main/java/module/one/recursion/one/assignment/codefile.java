package module.one.recursion.one.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class codefile {

    public static void main(String[] args) {
        printPermutations(new int[]{1, 2, 3});
        printPermutations(new int[]{0, 1});
    }

    private static void printPermutations(int[] nums) {
        System.out.println("Permutations by approach 1: " + approach1(nums));
        System.out.println("Permutations by approach 2: " + approach2(nums));
        System.out.println();
    }

    private static List<List<Integer>> approach1(int[] nums) {
        return helper1(nums, 0);
    }

    private static List<List<Integer>> helper1(int[] nums, int index) {
        if (index == nums.length) {
            return new ArrayList<>(List.of(Arrays.stream(nums).boxed().toList()));
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            list.addAll(helper1(nums, index + 1));
            swap(nums, i, index);
        }
        return list;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*private static List<List<Integer>> recurPermute(int index, int[] nums) {
        if (index == nums.length) {
            return new ArrayList<>(List.of(new ArrayList<>(Arrays.stream(nums).boxed().toList())));
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            list.addAll(recurPermute(index + 1, nums));
            swap(nums, index, i);
        }
        return list;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> approach1(int[] nums) {
        //List<List<Integer>> ans = new ArrayList<>();
        return recurPermute(0, nums);
        //return ans;
    }*/

    private static List<List<Integer>> approach2(int[] nums) {
        return helper2(nums, new ArrayList<>(), new boolean[nums.length]);
    }

    private static List<List<Integer>> helper2(int[] nums, List<Integer> permutation, boolean[] visited) {
        if (permutation.size() == nums.length) {
            return new ArrayList<>(List.of(new ArrayList<>(permutation)));
        }
        List<List<Integer>> permutationList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(nums[i]);
                permutationList.addAll(helper2(nums, permutation, visited));
                visited[i] = false;
                permutation.removeLast();
            }
        }
        return permutationList;
    }

}