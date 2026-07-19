package module.three.lld.principles;

import java.util.List;

/**
 * Single Responsibility Principle:
 * <p>
 * Low-Level Designing (LLD)
 * - Low-level design (LLD) is a critical phase in software development where the high-level design of a system is decomposed into
 * detailed and concrete specifications.
 * - This phase focuses on defining individual modules, their interrelationships, and their functionalities.
 * - LLD emphasizes implementation details, including data structures, algorithms, and interfaces, to create a blueprint for building
 * the software.
 * <p>
 * Key Components of LLD:
 * - Modules: Defined as self-contained units that encapsulate functionality.
 * - Interfaces: Specifies the methods that the modules expose for interaction.
 * - Data Structures: Defines how data is organized, accessed, and manipulated.
 * - Algorithms: The step-by-step procedures for performing computations or data manipulations.
 * <p>
 * Design Principles"
 * - Design principles are fundamental guidelines that aid developers in crafting maintainable, scalable, and robust software systems.
 * - They facilitate the creation of software with desirable qualities, such as flexibility, modularity, and reusability.
 * <p>
 * Importance of Design Principles:
 * - Maintainability: Code is easier to understand and modify, reducing future development costs.
 * - Adaptability: Changes can be made without extensive rework, ensuring longevity.
 * - Collaboration: Shared understanding among team members leads to improved teamwork.
 * <p>
 * SOLID Principles:
 * - SOLID is an acronym for five design principles introduced by Robert C. Martin to guide object-oriented software design:
 * <p>
 * Single Responsibility Principle (SRP)
 * - Definition: A class should have only one reason to change, meaning it should have a single responsibility.
 * - Benefits:
 * Reduces complexity.
 * Makes code more understandable.
 * Enhances maintainability.
 * <p>
 * - To illustrate SRP, let's consider an application that calculates the total area of a collection of shapes (circles and squares).
 * - We'll start by creating the shape classes and then develop a calculator to sum their areas.
 */
public class _1SRP {

    public static void main(String[] args) {
        badExample();
        goodExample();
    }

    /**
     * This is a bad example because single class is calculating the area sum and also returning the output in json and html.
     * As per Single Responsibility Principle, there should be one and only one reason to make changes in a class.
     * But here, is we need to change output returning logic or area sum calculation logic, will have to make changes in same class.
     * This is the violation of the SRP.
     */
    private static void badExample() {
        ShapeAreaPrinter shapeAreaPrinter = new ShapeAreaPrinter(List.of(new Square(2), new Circle(2)));
        System.out.println("JSON: " + shapeAreaPrinter.toJson());
        System.out.println("HTML: " + shapeAreaPrinter.toHtml());
    }

    /**
     * This is a good example as we have separate classes for calculating the area sum and returning the json and html.
     * We can further divide json and html output in separate classes.
     */
    private static void goodExample() {
        AreaCalculator calculator = new AreaCalculator(List.of(new Square(4), new Circle(4)));
        AreaCalculatorPrinter printer = new AreaCalculatorPrinter(calculator);
        System.out.println("JSON: " + printer.toJson());
        System.out.println("HTML: " + printer.toHtml());
    }

}

class Square {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public double area() {
        return this.side * this.side;
    }
}

class Circle {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return 3.142 * this.radius * this.radius;
    }
}

//////////////////////////////////// BAD EXAMPLE ///////////////////////////////////
class ShapeAreaPrinter {
    private List<Object> shapes;

    public ShapeAreaPrinter(List<Object> shapes) {
        this.shapes = shapes;
    }

    public double sum() {
        double totalArea = 0;
        for (Object shape : shapes) {
            if (shape instanceof Square) {
                totalArea += ((Square) shape).area();
            } else if (shape instanceof Circle) {
                totalArea += ((Circle) shape).area();
            }
        }
        return totalArea;
    }

    public String toJson() {
        return "{ sum: " + sum() + "}";
    }

    public String toHtml() {
        return "<p>Sum of the areas of provided shapes: " + sum() + "</p>";
    }
}

//////////////////////////////////// GOOD EXAMPLE ////////////////////////////////////
class AreaCalculator {
    private List<Object> shapes;

    public AreaCalculator(List<Object> shapes) {
        this.shapes = shapes;
    }

    public double sum() {
        double totalArea = 0;
        for (Object shape : shapes) {
            if (shape instanceof Square) {
                Square square = (Square) shape;
                totalArea += square.area();
            } else if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                totalArea += circle.area();
            }
        }
        return totalArea;
    }
}

class AreaCalculatorPrinter {
    private AreaCalculator calculator;

    public AreaCalculatorPrinter(AreaCalculator calculator) {
        this.calculator = calculator;
    }

    public String toJson() {
        return "{ sum: " + calculator.sum() + "}";
    }

    public String toHtml() {
        return "<p>Sum of the areas of provided shapes: " + calculator.sum() + "</p>";
    }
}