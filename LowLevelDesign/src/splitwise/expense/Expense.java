package splitwise.entities;

import splitwise.entities.enums.ExpenseSplitType;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType splitType;
    List<Split> splitDetails = new ArrayList<>();

    public Expense(String description, double expenseAmount, String expenseId,
                   User paidByUser, List<Split> splitDetails, ExpenseSplitType splitType) {
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.expenseId = expenseId;
        this.paidByUser = paidByUser;
        this.splitDetails = splitDetails;
        this.splitType = splitType;
    }
}
