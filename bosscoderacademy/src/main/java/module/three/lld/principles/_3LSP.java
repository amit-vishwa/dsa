package module.three.lld.principles;

/**
 * Liskov Substitution Principle (LSP):
 * <p>
 * Subclasses should be substitutable for their base classes without affecting the correctness of the program.
 * <p>
 * The Liskov Substitution Principle (LSP) states:
 * Let q(x) be a property provable about objects of x of type T.
 * Then q(y) should be provable for objects y of type S where S is a subtype of T.
 * This means that every subclass or derived class should be substitutable for their base or parent class.
 * <p>
 * Building off the example of the AreaCalculator class, let's consider a new VolumeCalculator class that extends the AreaCalculator class.
 */
public class _3LSP {

    public static void main(String[] args) {
        badExample();
        goodExample();
    }

    /**
     * This is a bad example because here we are calculating the sum of volume but returning the value as 0.
     * The sum will be different for parent and child class.
     * This is violating the LSP principle.
     */
    private static void badExample() {
        System.out.println("Bad example:");
        IShape[] shapes = {new CSquare(2), new CRectangle(2, 4)};
        CAreaCalculator areaCalculator = new CAreaCalculator(shapes);
        System.out.println("Area sum: " + areaCalculator.sum());
        shapes[1] = new CRectangle(2, 4, 8);
        VolumeCalculator volumeCalculator = new VolumeCalculator(shapes);
        System.out.println("Volume sum: " + volumeCalculator.sum());
        System.out.println();
    }

    /**
     * This is a good example because here we are calculating the sum of volume by implementing interface.
     * We are not using the parent class to calculate sum.
     * We are following the LSP here.
     */
    private static void goodExample() {
        System.out.println("Good example:");
        IShape[] shapes = {new CSquare(2), new CRectangle(2, 4)};
        CAreaCalculator areaCalculator = new CAreaCalculator(shapes);
        System.out.println("Area sum: " + areaCalculator.sum());
        shapes[1] = new CRectangle(2, 4, 8);
        CVolumeCalculator volumeCalculator = new CVolumeCalculator(shapes);
        System.out.println("Volume sum: " + volumeCalculator.sum());
        System.out.println();
    }

}

interface IShape {
    public double area();

    public double volume();
}

class CSquare implements IShape {
    private final double side;

    public CSquare(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return this.side * this.side;
    }

    @Override
    public double volume() {
        return this.side * this.side * this.side;
    }
}

class CRectangle implements IShape {
    private final double length, breadth, height;

    public CRectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
        this.height = 0;
    }

    public CRectangle(double length, double breadth, double height) {
        this.length = length;
        this.height = height;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return this.length * this.breadth;
    }

    @Override
    public double volume() {
        return this.length * this.breadth * this.height;
    }
}

interface ICalculator {
    public double sum();
}

class CAreaCalculator implements ICalculator {
    private final IShape[] shapes;

    public CAreaCalculator(IShape[] shapes) {
        this.shapes = shapes;
    }

    @Override
    public double sum() {
        double totalArea = 0;
        for (IShape shape : shapes) {
            totalArea += shape.area();
        }
        return totalArea;
    }
}

///////////////////////////////// BAD EXAMPLE ////////////////////////////////////
class VolumeCalculator extends CAreaCalculator {

    public VolumeCalculator(IShape[] shapes) {
        super(shapes);
    }

    @Override
    public double sum() {
        return 0;
    }
}

///////////////////////////////// GOOD EXAMPLE ////////////////////////////////////
class CVolumeCalculator implements ICalculator {

    private IShape[] shapes;

    public CVolumeCalculator(IShape[] shapes) {
        this.shapes = shapes;
    }

    public double sum() {
        double total = 0;
        for (IShape shape : shapes) {
            total += shape.volume();
        }
        return total;
    }
}
