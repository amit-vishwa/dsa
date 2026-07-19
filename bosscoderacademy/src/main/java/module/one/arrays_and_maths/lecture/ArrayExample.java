package module.one.arrays_and_maths.lecture;

public class ArrayExample {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(max(arr));
        arr = null;
        System.out.println(arr);
    }

    private static int max(int[] arr) {
        int max = 0;
        for (int n : arr) {
            max = Math.max(n, max);
        }
        return max;
    }

}
