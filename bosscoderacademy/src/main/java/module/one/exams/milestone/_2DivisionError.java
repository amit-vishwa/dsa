package module.one.exams.milestone;

/**
 * Refer: _6DivisionError.java file from package module.one.exams.two.
 */
public class _2DivisionError {

    public static void main(String[] args) {
        System.out.println(isErrorSafe(4, 2));
        System.out.println(isErrorSafe(41, 0));
    }

    private static boolean isErrorSafe(int a, int b) {
        return b != 0;
    }

}
