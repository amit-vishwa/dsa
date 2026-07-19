package module.one.recursion.one.notes;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            boolean isLeftCharAlphaNum = (leftChar >= 48 && leftChar <= 57) || (leftChar >= 65 && leftChar <= 90)
                    || (leftChar >= 97 && leftChar <= 122) || leftChar == 32;
            boolean isRightCharAlphaNum = (rightChar >= 48 && rightChar <= 57) || (rightChar >= 65 && rightChar <= 90)
                    || (rightChar >= 97 && rightChar <= 122) || rightChar == 32;
            if (isLeftCharAlphaNum && isRightCharAlphaNum) {
                if (leftChar != rightChar) {
                    return false;
                }
                left++;
                right--;
            } else if (!isLeftCharAlphaNum && !isRightCharAlphaNum) {
                left++;
                right--;
            } else if (!isRightCharAlphaNum) {
                right--;
            } else {
                left++;
            }
        }
        return true;
    }
}