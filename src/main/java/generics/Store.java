package generics;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-19
 * Time: 下午9:38
 */
public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkoutStands = new ArrayList<CheckoutStand>();
    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts) {
        for(int i=0; i<nAisles; i++)
            add(new Aisle(nShelves, nProducts));
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Aisle a : this)
            for(Shelf s : a)
                for(Product p : s) {
                    result.append(p);
                    result.append("\n");
                }
        return result.toString();
    }

    public static void main(String[] args) {
        PrintUtil.print(new Store(14, 5, 10));
    }
}

class Product {
    private final int id;
    private String description;
    private double price;

    Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        PrintUtil.print(toString());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Product> generator =
            new Generator<Product>() {
                private Random random = new Random(23);
                @Override
                public Product next() {
                    return new Product(random.nextInt(1000), "Test", Math.round(random.nextDouble() * 1000.0) + 0.99);
                }
            };
}

class Shelf extends ArrayList<Product> {
    public Shelf(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}

class Aisle extends ArrayList<Shelf> {
    public Aisle(int nShelves, int nProducts) {
        for(int i=0; i<nShelves; i++)
            add(new Shelf(nProducts));
    }
}

class CheckoutStand {}

class Office {}
