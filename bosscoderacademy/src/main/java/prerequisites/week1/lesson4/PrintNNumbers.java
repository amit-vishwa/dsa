package prerequisites.week1.lesson4;

import java.util.Scanner;

/**
 * Print first N numbers.
 */
public class PrintNNumbers {

    public static void main(String[] args) {
        print(new Scanner(System.in).nextInt());
    }

    static void print(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
    }

}
