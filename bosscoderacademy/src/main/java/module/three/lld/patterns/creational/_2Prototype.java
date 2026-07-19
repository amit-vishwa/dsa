package module.three.lld.patterns.creational;

class Product {
    private final String name;
    private int cost;

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public Product clone() {
        return new Product(this.name, this.cost);
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String toString() {
        return "{ name: " + this.name + ", cost: " + this.cost + "}";
    }
}

/**
 * Clone existing objects to create new ones without depending on their concrete classes.
 */
public class _2Prototype {

    public static void main(String[] args) {
        Product product1 = new Product("Haier", 10000);
        Product product2 = product1.clone();
        System.out.println(product1 == product2);
        product2.setCost(20000);
        System.out.println("Product1: " + product1.toString());
        System.out.println("Product2: " + product2.toString());
    }

}
