package module.two.queues.notes;

/**
 * Get the kth smallest number using the digits of the given number:
 * <p>
 * Given a non-negative number n and a value k. Find the kth smallest number that can be formed using the digits of the given
 * number n. It is guaranteed that the kth smallest number can be formed. Note that the number could be very large and may not
 * even fit into long int.
 * <p>
 * Examples:
 * Input : n = 1234, k = 2
 * Output : 1243
 * <p>
 * Input : n = 36012679802, k = 4
 * Output : 10022366897
 * <p>
 * The idea is to first sort digits and find the smallest number, then find k-th permutation starting from smallest number.
 * To sort digits, we use an frequency counting technique as number of digits are small.
 * <p>
 * Understand the code and approach properly and re-write it.
 */
public class _4KthSmallest {

    public static void main(String[] args) {
        System.out.println(kthSmallestNumber("1234", 2));
        System.out.println(kthSmallestNumber("36012679802", 4));
    }

    // function to get the kth smallest number
    static String kthSmallestNumber(String num, int k) {
        // FIND SMALLEST POSSIBLE NUMBER BY SORTING
        // DIGITS

        // count frequency of each digit
        int[] freq = new int[10];
        StringBuilder final_num = new StringBuilder();

        int n = num.length();

        // counting frequency of each digit
        for (int i = 0; i < n; i++) {
            freq[num.charAt(i) - '0']++;
        }

        // get the smallest digit greater than 0
        char s_dgt = getSmallDgtGreaterThanZero(num, n);

        // add 's_dgt' to 'final_num'
        final_num.append(s_dgt);

        // reduce frequency of 's_dgt' by 1 in 'freq'
        freq[s_dgt - '0']--;

        // add each digit according to its frequency
        // to 'final_num'
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= freq[i]; j++) {
                final_num.append((char) (i + '0'));
            }
        }

        // FIND K-TH PERMUTATION OF SMALLEST NUMBER
        for (int i = 1; i < k; i++) {
            String temp = final_num.toString();
            final_num = new StringBuilder();
            final_num.append(nextPermutation(temp));
        }

        // required kth smallest number
        return final_num.toString();
    }

    // function to get the smallest digit in 'num'
    // which is greater than 0
    static char getSmallDgtGreaterThanZero(String num,
                                           int n) {
        // 's_dgt' to store the smallest digit
        // greater than 0
        char s_dgt = '9';
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) < s_dgt
                    && num.charAt(i) != '0') {
                s_dgt = num.charAt(i);
            }
        }

        // required smallest digit in 'num'
        return s_dgt;
    }

    // function to find the next permutation of a given
    // string
    static String nextPermutation(String str) {
        char[] arr = str.toCharArray();
        int i = arr.length - 2;

        // find the rightmost element that is smaller than
        // its next element
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // if no such element is found, the string is
        // already the last permutation
        if (i < 0) {
            return str;
        }

        // find the smallest element to the right of the
        // element found above that is greater than it
        int j = arr.length - 1;
        while (j > i && arr[j] <= arr[i]) {
            j--;
        }

        // swap the two elements
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // reverse the substring to the right of the first
        // element found above
        int left = i + 1;
        int right = arr.length - 1;
        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        // requires kth smallest number
        return new String(arr);
    }


}
