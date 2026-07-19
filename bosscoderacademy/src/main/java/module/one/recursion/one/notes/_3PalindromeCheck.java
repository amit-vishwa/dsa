package module.one.recursion.one.notes;

/**
 * The string is palindrome or not:
 * <p>
 * Given a string S, check if it is a palindrome or not. (A palindrome is a string that is the same from forward and backward.)
 * <p>
 * Example
 * Input: S = "abba"
 * Output: 1
 * <p>
 * Approaches:
 * - There are multiple approaches to solve this problem.
 * - We have used recursive and iterative approach both.
 * - The approaches from 4 till 6 are recursive ones, previous ones are iterative approaches.
 * - The time complexity is O(N) i.e. length of the string.
 * - The space complexity is O(N) where we are using extra reverse string, else it is O(1).
 */
public class _3PalindromeCheck {

    public static void main(String[] args) {
        palindromeCheck("abba");
        palindromeCheck("abbaa");
    }

    private static void palindromeCheck(String str) {
        System.out.println("Check if string is palindrome by approach 1: " + approach1(str));
        System.out.println("Check if string is palindrome by approach 2: " + approach2(str));
        System.out.println("Check if string is palindrome by approach 3: " + approach3(str));
        System.out.println("Check if string is palindrome by approach 4: " + approach4(str));
        System.out.println("Check if string is palindrome by approach 5: " + approach5(str));
        System.out.println("Check if string is palindrome by approach 6: " + approach6(str));
        System.out.println();
    }

    private static boolean approach1(String str) {
        String revStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revStr += str.charAt(i);
        }
        return revStr.equals(str);
    }

    private static boolean approach2(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    private static boolean approach3(String str) {
        int l = 0, r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    private static boolean approach4(String str) {
        String revStr = approach4Helper(str, "", str.length() - 1);
        return revStr.equals(str);
    }

    private static String approach4Helper(String str, String rev, int index) {
        if (rev.length() == str.length()) {
            return rev;
        }
        return approach4Helper(str, rev + str.charAt(index), index - 1);
    }

    private static boolean approach5(String str) {
        return approach5Helper(str, 0, str.length() - 1);
    }

    private static boolean approach5Helper(String str, int l, int r) {
        if (l >= r) {
            return true;
        }
        if (str.charAt(l) != str.charAt(r)) {
            return false;
        }
        return approach5Helper(str, l + 1, r - 1);
    }

    private static boolean approach6(String str) {
        return approach6Helper(str, 0);
    }

    private static boolean approach6Helper(String str, int index) {
        if (index > str.length() / 2) {
            return true;
        }
        return str.charAt(index) == str.charAt(str.length() - 1 - index) && approach6Helper(str, index + 1);
    }

}
