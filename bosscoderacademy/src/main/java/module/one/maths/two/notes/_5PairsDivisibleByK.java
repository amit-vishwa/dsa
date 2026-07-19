package module.one.maths.two.notes;

public class _5PairsDivisibleByK {

    public static void main(String[] args) {
        printPairCount(new int[]{2, 2, 1, 7, 5, 3}, 4, 6);
    }

    private static void printPairCount(int[] arr, int k, int n) {
        approach1(arr, k, n);
        approach2(arr, k, n);
        System.out.println();
    }

    /**
     * Approach 1: Bruteforce approach
     * - Here, we are simply checking for all pairs.
     * - Adding the pairs and checking if it is divisible by K.
     * - Increment the counter if divisible, else skip.
     * - Time complexity: O(N^2) as we are using nest loop here.
     * - Space complexity: O(1), no extra space is used.
     */
    private static void approach1(int[] arr, int k, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] + arr[j]) % k == 0) {
                    count++;
                }
            }
        }
        System.out.println("Approach 1: Pairs divisible by K: " + count);
    }

    /**
     * Approach 2: Optimal approach
     * - Here, we have to create a frequency array to store remainders count.
     * - We will iterate through the given array and populate the remainder count values in frequency array.
     * - Then will calculate the count for remainder 0, by reducing 1 for unique combination i.e. (5,5) not repeated
     * twice, also we will divide by 2 to avoid commutative values like if (1,5) already counted then no need to
     * count the pair of (5,1).
     * - Then will iterate through frequency array and calculate count till mid, for even K we are skipping mid here
     * as it will be counted twice because we are calculating from start and end both at the same time.
     * - After frequency loop iteration to calculate count, we are calculating the mid of even values.
     * - Finally, we will be left with the count values.
     * - Time complexity: O(N) for iterating array + O(k / 2) for frequency array = O(N) + O(K/2) = O(N) as K/2 is small
     * - Space complexity: O(K), to create frequency array.
     */
    private static void approach2(int[] arr, int k, int n) {
        int[] freq = new int[k];
        for (int num : arr) {
            int rem = ((num % k) + k) % k;
            freq[rem]++;
        }
        int count = freq[0] * (freq[0] - 1) / 2;
        for (int i = 1; i < (k + 1) / 2; i++) {
            count += freq[i] * freq[k - i];
        }
        if (k % 2 == 0) {
            count += freq[k / 2] * (freq[k / 2] - 1) / 2;
        }
        System.out.println("Approach 2: Pairs divisible by K: " + count);
    }

}