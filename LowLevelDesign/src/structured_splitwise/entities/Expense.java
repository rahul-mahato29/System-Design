package structured_splitwise.entities;


import structured_splitwise.entities.enums.ExpenseSplitType;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType splitType;
    List<Split> splitDetails = new ArrayList<>();

    public Expense(String expenseId, String description, double expenseAmount, User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitDetails = splitDetails;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public void setPaidByUser(User paidByUser) {
        this.paidByUser = paidByUser;
    }

    public void setSplitDetails(List<Split> splitDetails) {
        this.splitDetails = splitDetails;
    }

    public void setSplitType(ExpenseSplitType splitType) {
        this.splitType = splitType;
    }

    public String getDescription() {
        return description;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public User getPaidByUser() {
        return paidByUser;
    }

    public List<Split> getSplitDetails() {
        return splitDetails;
    }

    public ExpenseSplitType getSplitType() {
        return splitType;
    }
}
