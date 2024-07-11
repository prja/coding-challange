package prja.leetcode.challange.lambda;
import java.util.Arrays;
import java.util.List;

public class Product {
    private String name;
    private String category;
    private double price;
    private boolean available;

    public Product(String name, String category, double price, boolean available) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
