package module.three.lld.principles;

/**
 * Interface Segregation Principle (ISP):
 * <p>
 * - The Interface Segregation Principle (ISP) is a crucial design principle in software development that advocates for the creation of
 * specific and focused interfaces.
 * - The essence of ISP is that clients should not be forced to depend on interfaces they do not use.
 * - This principle emphasizes that a class should not be burdened with implementing methods that are irrelevant to its intended
 * functionality, thus promoting cleaner and more maintainable code.
 * - When interfaces are too broad, they can lead to scenarios where classes are required to implement methods that they do not need.
 * - This can lead to confusion and unnecessary complexity, as clients are forced to implement functionality that does not align with
 * their specific requirements.
 * - By following the ISP, we ensure that interfaces are designed to be small and focused, allowing classes to implement only the
 * methods they require.
 * - Let’s explore how the Interface Segregation Principle can be implemented using an example.
 * - We’ll use a shape-related scenario where we have both two-dimensional and three-dimensional shapes.
 */
public class _4ISP {

    public static void main(String[] args) {
        badExample();
        goodExample();
    }

    /**
     * This is a bad example because Cuboid is forced to implement area method from parent interface, even though it is of no use.
     * This is violating the Interface Segregation Principle.
     */
    private static void badExample() {
        ShapeIn shape = new Cuboid(2, 3, 4);
        System.out.println("Volume: " + shape.volume());
    }

    /**
     * This is a good example as interfaces are segregated and they are used as per requirement.
     * This is following the ISP principle.
     */
    private static void goodExample() {
        TwoDimensionalShapeInterface square = new SquareShapeClass(4);
        ThreeDimensionalShapeInterface cuboid = new CuboidShapeClass(2, 4, 8);
        System.out.println("Area of Square: " + square.area());
        System.out.println("Volume of Cuboid: " + cuboid.volume());
    }

}

///////////////////////////////// BAD EXAMPLE //////////////////////////////////
interface ShapeIn {
    public double area();

    public double volume();
}

class Cuboid implements ShapeIn {
    private final double l, b, h;

    Cuboid(double l, double b, double h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }

    @Override
    public double area() {
        return 0; // area not required
    }

    @Override
    public double volume() {
        return l * b * h;
    }
}

//////////////////////////////////// GOOD EXAMPLE ///////////////////////////////////////
interface TwoDimensionalShapeInterface {
    double area();
}

interface ThreeDimensionalShapeInterface {
    double volume();
}

class SquareShapeClass implements TwoDimensionalShapeInterface {
    private final double side;

    public SquareShapeClass(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return this.side * this.side;
    }
}

class CuboidShapeClass implements ThreeDimensionalShapeInterface {
    private final double length, breadth, height;

    public CuboidShapeClass(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    @Override
    public double volume() {
        return this.length * this.breadth * this.height;
    }
}
