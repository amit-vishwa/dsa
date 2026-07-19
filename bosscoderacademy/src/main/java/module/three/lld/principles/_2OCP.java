package module.three.lld.principles;

/**
 * Open-Closed Principle (OCP):
 * <p>
 * Definition: Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
 * <p>
 * Benefits:
 * - Encourages the addition of new features without altering existing code.
 * - Enhances stability and reduces the risk of introducing bugs.
 * <p>
 * Let's revisit the AreaCalculator class and focus on the sum method. We'll then convert the example to Java and ensure it adheres to
 * the OCP.
 */
public class _2OCP {

    public static void main(String[] args) {
        badExample();
        goodExample();
    }

    /**
     * This is a bad example, because it is not scalable and will have to change or modify the existing class code.
     * Consider a scenario where the user would like the sum of additional shapes like triangles, pentagons, hexagons, etc.
     * You would have to constantly edit this ShapeAreaCalculator file and add more if/else blocks, violating the OCP.
     */
    private static void badExample() {
        ShapeAreaCalculator shapeAreaCalculator = new ShapeAreaCalculator(new Object[]{new SquareShape(2), new CircleShape(4)});
        System.out.println("Sum of shape area: " + shapeAreaCalculator.sum());
    }

    /**
     * This is a good example as it follows the Open Closed Principle here.
     * We have created an interface named Shape that will be implemented by different shapes class to calculate area.
     * This results in open for extension and closed for modification principle.
     */
    private static void goodExample() {
        Shape[] shapes = {new ShapeSquare(2), new ShapeCircle(4), new ShapeRectangle(2, 4)};
        ShapesAreaCalculator shapesAreaCalculator = new ShapesAreaCalculator(shapes);
        System.out.println("Sum of shapes area: " + shapesAreaCalculator.sum());
    }

}

/////////////////////////////////////// BAD EXAMPLE ///////////////////////////////////////
class SquareShape {
    double side;

    public SquareShape(double side) {
        this.side = side;
    }

    public double area() {
        return this.side * this.side;
    }
}

class CircleShape {
    double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    public double area() {
        return 3.142 * this.radius * this.radius;
    }
}

class ShapeAreaCalculator {
    Object[] shapes;

    public ShapeAreaCalculator(Object[] shapes) {
        this.shapes = shapes;
    }

    public double sum() {
        double total = 0;
        for (Object shape : shapes) {
            if (shape instanceof SquareShape) {
                total += ((SquareShape) shape).area();
            } else if (shape instanceof CircleShape) {
                total += ((CircleShape) shape).area();
            }
        }
        return total;
    }
}

/////////////////////////////////////// GOOD EXAMPLE ///////////////////////////////////////
interface Shape {
    double area();
}

class ShapeSquare implements Shape {
    double side;

    public ShapeSquare(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return this.side * this.side;
    }
}

class ShapeCircle implements Shape {
    double radius;

    public ShapeCircle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.142 * this.radius * this.radius;
    }
}

class ShapeRectangle implements Shape {
    double length, breadth;

    public ShapeRectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return this.length * this.breadth;
    }
}

class ShapesAreaCalculator {
    Shape[] shapes;

    public ShapesAreaCalculator(Shape[] shapes) {
        this.shapes = shapes;
    }

    public double sum() {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.area();
        }
        return total;
    }
}