package prja.leetcode.challange.lambda;
import java.math.BigDecimal;

public class SalesTransaction {
    private String salesperson;
    private String productCategory;
    private BigDecimal amount;

    public SalesTransaction(String salesperson, String productCategory, BigDecimal amount) {
        this.salesperson = salesperson;
        this.productCategory = productCategory;
        this.amount = amount;
    }

    public String getSalesperson() {
        return salesperson;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
