package module.one.exams.milestone;

/**
 * Find prime numbers in a given range both inclusive, exclude a prime number if it contains digit 3 in it.
 */
public class _3ConstraintPrimes {

    public static void main(String[] args) {
        primeNumbers(10, 30);
        primeNumbers(30, 40);
    }

    private static void primeNumbers(int start, int end) {
        for (int num = start; num <= end; num++) {
            if (isPrime(num) && !containsDigit3(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsDigit3(int num) {
        return String.valueOf(num).contains("3");
    }

}
