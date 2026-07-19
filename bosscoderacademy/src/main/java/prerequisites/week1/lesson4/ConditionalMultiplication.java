package prerequisites.week1.lesson4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://platform.bosscoderacademy.com/prerequisites-editor/multiplication_table_conditional?prerequisites=True
 */
public class ConditionalMultiplication {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(3, 10)));
        System.out.println(Arrays.toString(solve(5, 3)));
    }

    static String[] solve(int n, int m) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            if (n * i % 4 == 0) {
                list.add(n + " x " + i + " = " + (n * i));
            }
        }
        if (list.isEmpty()) {
            return new String[]{"No qualifying multiples found."};
        }
        return list.toArray(new String[0]);
    }

}
