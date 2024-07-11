package prja.leetcode.challange.lambda;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
	private int orderId;
	 private int customerId;
    private String customerName;
    private LocalDate orderDate;
    private List<OrderItem> items;
    

    public Order(String customerName, LocalDate orderDate, OrderItem... items) {
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.items = new ArrayList<>(Arrays.asList(items));
    }

    public Order(int orderId, int customerId, LocalDate orderDate, OrderItem... orderItems) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.items = Arrays.asList(orderItems);
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", orderDate=" + orderDate +
                ", items=" + items +
                '}';
    }

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
}
