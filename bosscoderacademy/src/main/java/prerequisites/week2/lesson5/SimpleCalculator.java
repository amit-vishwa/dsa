package prerequisites.week2.lesson5;

import java.util.Scanner;

/**
 * Design a simple calculator that demonstrates the following System Design principles:
 * 1. Separation of Concerns (SoC): Each component should be separated and not impact others.
 * 2. Modularization: Code should be modular so that it can be used with other classes.
 * 3. Orchestration: A central code should be there that co-ordinate with processing unit to produce
 * actual result like a controller calls service layer for logic and then returns result in MVC architecture.
 * 4. Fault Tolerance and Input Validation: Input should be validated properly by performing exception handling.
 *
 * https://docs.google.com/document/d/1GESlaIGVLRdw5nPmcN9Dm9w0ucjTdk5XqXqmBjDdiFA/edit?tab=t.0#heading=h.mpziv0216vkv
 */
public class SimpleCalculator {

    public static void main(String[] args) {
        calculator();
    }

    static void calculator() {
        System.out.println("!! Simple Calculator !!");
        System.out.println("""
                
                | Input | Operation      |
                |   +   | Addition       |
                |   -   | Subtraction    |
                |   *   | Multiplication |
                |   /   | Division       |
                |   %   | Modulo         |
                |   .   | Stop           |                
                """);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter operation: ");
        char ch = scanner.next().charAt(0);
        while (ch != '.') {
            try {
                System.out.print("Enter first input: ");
                int a = scanner.nextInt();
                System.out.print("Enter second input: ");
                int b = scanner.nextInt();
                calculate(ch, a, b);
            } catch (Exception e) {
                System.out.println("Not a valid number");
            }
            System.out.print("\nEnter operation: ");
            ch = scanner.next().charAt(0);
        }
        System.out.println("\nShutting down the calculator...");
    }

    static void calculate(char ch, int a, int b) {
        switch (ch) {
            case '+' -> add(a, b);
            case '-' -> subtract(a, b);
            case '*' -> multiply(a, b);
            case '/' -> {
                if (b != 0) {
                    division(a, b);
                } else {
                    System.out.println("Not a valid operation");
                }
            }
            case '%' -> modulo(a, b);
            default -> System.out.println("Not a valid operation");
        }
    }

    static void add(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    static void subtract(int a, int b) {
        System.out.println(a + " - " + b + " = " + (a - b));
    }

    static void multiply(int a, int b) {
        System.out.println(a + " * " + b + " = " + (a * b));
    }

    static void division(int a, int b) {
        System.out.println(a + " / " + b + " = " + (a / b));
    }

    static void modulo(int a, int b) {
        System.out.println(a + " % " + b + " = " + (a % b));
    }

}
