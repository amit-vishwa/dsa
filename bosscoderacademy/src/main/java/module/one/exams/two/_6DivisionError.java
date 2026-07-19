package module.one.exams.two;

/**
 * Division Error -> Return false if divide by zero exception occurs, else return true
 */
public class _6DivisionError {

    public static void main(String[] args) {
        printIfDivisionPossible(10, 0);
        printIfDivisionPossible(10, 10);
    }

    private static void printIfDivisionPossible(int a, int b) {
        System.out.println(approach1(a, b));
        System.out.println(approach2(a, b));
        System.out.println();
    }

    private static boolean approach1(int a, int b) {
        return b != 0;
    }

    private static boolean approach2(int a, int b) {
        try {
            int c = a / b;
            return true;
        } catch (ArithmeticException e) {
            return false;
        }
    }

}
