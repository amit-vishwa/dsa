package prerequisites.week3.lesson1;

/**
 * 4. Inverted Pyramid (Centered)
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 * */
public class Pattern4 {

    public static void main(String[] args) {
        printPattern(3);
        printPattern(5);
    }

    static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = n * 2 - (2 * i + 1); j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
