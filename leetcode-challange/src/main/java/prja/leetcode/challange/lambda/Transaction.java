package prja.leetcode.challange.lambda;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Transaction {
    private int transactionId;
    private String type;
    private BigDecimal amount;
    private LocalDate date;
    private LocalDateTime timestamp;
    public Transaction(int transactionId, String type, BigDecimal amount, LocalDate date) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(int transactionId, BigDecimal amount, String type, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.setTimestamp(timestamp);
    }
    public int getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
}
