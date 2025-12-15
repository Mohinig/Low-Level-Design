package Splitwise.models;

import java.util.List;

public abstract class Expense {
    private String id;
    private User paidBy;
    private double amount;
    private List<Split> splits;
    private ExpenseMetadata metadata;

    public Expense(User paidBy, double amount, List<Split> splits, ExpenseMetadata metadata) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.splits = splits;
        this.metadata = metadata;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public ExpenseMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ExpenseMetadata metadata) {
        this.metadata = metadata;
    }
    public abstract boolean validate();
}
