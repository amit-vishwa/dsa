package module.three.lld.patterns.behavioral;

/**
 * Strategy Pattern:
 * - DiscountStrategy defines a family of discount algorithms.
 * - StudentDiscount, EmployeeDiscount, and HolidayDiscount provide different implementations of the algorithm.
 * - CheckoutService acts as the Context and delegates discount calculation to the current strategy.
 * - The strategy can be changed at runtime.
 */
public class _1Strategy {

    public static void main(String[] args) {
        double total = 140.0;
        CheckoutService checkoutService = new CheckoutService(new HolidayDiscount());
        System.out.println("Holiday discount: " + checkoutService.checkout(total));
        checkoutService.setDiscountStrategy(new EmployeeDiscount());
        System.out.println("Employee discount: " + checkoutService.checkout(total));
        checkoutService.setDiscountStrategy(new StudentDiscount());
        System.out.println("Student discount: " + checkoutService.checkout(total));
    }

}

interface DiscountStrategy {
    double applyDiscount(double total);
}

class StudentDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.75; // 25% off
    }
}

class EmployeeDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.80; // 20% off
    }
}

class HolidayDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.90; // 10% off
    }
}

class CheckoutService {
    private DiscountStrategy discountStrategy;

    public CheckoutService(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double checkout(double cartTotal) {
        validate(cartTotal);
        double finalPrice = this.discountStrategy.applyDiscount(cartTotal);
        logCheckout(cartTotal, finalPrice);
        return finalPrice;
    }

    private void validate(double cartTotal) {
        if (cartTotal < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }

    private void logCheckout(double originalAmount, double finalAmount) {
        System.out.printf("Original: %.2f, Final: %.2f", originalAmount, finalAmount);
    }
}