package prerequisites.week1.lesson1;

/**
 * https://platform.bosscoderacademy.com/prerequisites-editor/even_odd_print?prerequisites=True
 */
public class EvenOrOdd {

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(i + " is " + check(i));
        }
    }

    static String check(int n) {
        return n % 2 != 0 ? "Odd" : "Even";
    }

}
