package module.three.lld.principles;

import java.util.List;

/**
 * KISS (Keep It Simple, Stupid):
 * - The KISS (Keep It Simple, Stupid) principle advocates for simplicity in software design.
 * - Simple solutions are easier to understand, maintain, and extend than complex ones. KISS encourages avoiding unnecessary complexity,
 * convoluted code structures, or over-engineering.
 * <p>
 * Example for KISS (Keep It Simple, Stupid):
 * - Consider a scenario where you need to implement a function to calculate the average of a list of numbers.
 */
public class _7KISS {

    public static void main(String[] args) {
        badExample();
        goodExample();
    }

    /**
     * This is a bad example, because we are using more lines of code which are quite complex and not much readable.
     * It is violating the KISS principle.
     */
    private static void badExample() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        ComplexAverageCalculator calculator = new ComplexAverageCalculator();
        System.out.println("Average: " + calculator.calculateAverage(integers));
    }

    /**
     * This is quite a good example as it is using Java 8 streams api to make code concise and readable.
     * It is simple, and hence following the KISS principle.
     */
    private static void goodExample() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        SimpleAverageCalculator calculator = new SimpleAverageCalculator();
        System.out.println("Average: " + calculator.calculateAverage(integers));
    }

}

/////////////////////////////// BAD EXAMPLE //////////////////////////////////////
class ComplexAverageCalculator {
    public double calculateAverage(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / (double) numbers.size();
    }
}

/////////////////////////////// GOOD EXAMPLE //////////////////////////////////////
class SimpleAverageCalculator {
    public double calculateAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}