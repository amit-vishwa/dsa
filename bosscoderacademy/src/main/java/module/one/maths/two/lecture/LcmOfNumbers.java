package module.one.maths.two.lecture;

/**
 * Find the LCM of two numbers:
 * LCM = a * b / lcm(a, b)
 */
public class LcmOfNumbers {

    public static void main(String[] args) {
        System.out.println(lcm(25, 10));
        System.out.println(lcm(27, 20));
        System.out.println(lcm(20, 40));
        System.out.println(lcm(35, 45));
    }

    // Time and space complexity: O(log(min(a,b))), similar to GCD as n1*n2 and division by gcd takes O(1)
    private static int lcm(int n1, int n2) {
        return n1 * n2 / gcd(n1, n2);
    }

    // Time and space complexity: O(log(min(a,b)))
    private static int gcd(int n1, int n2) {
        return n1 == 0 ? n2 : gcd(n2 % n1, n1);
    }

}
