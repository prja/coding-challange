package prja.leetcode.challange.lambda;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Product2 {
    private int productId;
    private String name;
    private String category;
    private BigDecimal price;
    private int availability;

    public Product2(int productId, String name, String category, BigDecimal price, int availability) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.availability = availability;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                '}';
    }
}
