package prerequisites.week1.lesson4;

import java.util.Scanner;

/**
 * Check if number is divisible by 5 and 11. Print 'Yes' if yes, else print 'No'.
 */
public class DivisibleNumber {

    public static void main(String[] args) {
        System.out.println(isDivisible(new Scanner(System.in).nextInt()));
    }

    static String isDivisible(int n) {
        return n % 5 == 0 && n % 11 == 0 ? "Yes" : "No";
    }

}
