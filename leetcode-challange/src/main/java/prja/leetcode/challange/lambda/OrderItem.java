package prja.leetcode.challange.lambda;

import java.math.BigDecimal;

public class OrderItem {
	
    private String itemName;
    private BigDecimal price;
    private int quantity;
    private int productId;

    public OrderItem(String itemName, BigDecimal price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItem(int productId, int quantity, BigDecimal price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
    
    
    public OrderItem(int i, String string, int j, BigDecimal bigDecimal) {
		// TODO Auto-generated constructor stub
	}

	public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
