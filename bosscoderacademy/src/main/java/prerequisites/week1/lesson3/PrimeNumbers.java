package prerequisites.week1.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://platform.bosscoderacademy.com/prerequisites-editor/prime_number_range?prerequisites=True
 * */
public class PrimeNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(check(10, 30)));
        System.out.println(Arrays.toString(check(30, 35)));

        System.out.println(Arrays.toString(check2(10, 30)));
        System.out.println(Arrays.toString(check2(30, 35)));
    }

    static String[] check(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = n; i <= m; i++) {
            if (i > 1 && isPrime(i) && !String.valueOf(i).contains("3")) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return new String[]{"No valid primes found."};
        }
        String[] stringArray = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            stringArray[i] = String.valueOf(list.get(i));
        }
        return stringArray;
    }

    static String[] check2(int n, int m) {
        List<String> list = new ArrayList<>();
        for (int i = n; i <= m; i++) {
            if (i > 1 && isPrime(i) && !String.valueOf(i).contains("3")) {
                list.add(String.valueOf(i));
            }
        }
        if (list.isEmpty()) {
            return new String[]{"No valid primes found."};
        }
        return list.toArray(new String[0]);
    }

    static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
