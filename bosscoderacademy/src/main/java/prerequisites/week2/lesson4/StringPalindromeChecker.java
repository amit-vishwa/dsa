package prerequisites.week2.lesson4;

/**
 * https://platform.bosscoderacademy.com/prerequisites-editor/palindrome_string_checker?prerequisites=True
 * */
public class StringPalindromeChecker {

    public static void main(String[] args) {
        System.out.println(check("A man, a plan, a canal: Panama"));
        System.out.println(check("race a car"));
    }

    static boolean check(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            char left = s.charAt(l);
            char right = s.charAt(r);
            if ((left > 96 && left < 123) && (right > 96 && right < 123)) {
                if (left != right) {
                    return false;
                } else {
                    l++;
                    r--;
                }
            } else {
                if (left < 97 || left > 122) {
                    l++;
                }
                if (right < 97 || right > 122) {
                    r--;
                }
            }
        }
        return true;
    }

}
