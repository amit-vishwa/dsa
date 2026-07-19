package module.two._2pointers.notes;

// Refer _3SubArraySumEqualsK.java file from package module.two._2pointers.lecture;
public class _4SubArraySumEqualsK {

    public static void main(String[] args) {
        printCount(new int[]{1, 1, 1}, 2);
        printCount(new int[]{1, 2, 3}, 3);
    }

    private static void printCount(int[] nums, int k) {
        System.out.println("Sub array count by approach 1: " + approach1(nums, k));
        System.out.println("Sub array count by approach 2: " + approach2(nums, k));
        System.out.println();
    }

    private static int approach1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int x = i; x <= j; x++) {
                    sum += nums[x];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int approach2(int[] nums, int k) {
        int count = 0, n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = prefix[j] - prefix[i] + nums[i];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
