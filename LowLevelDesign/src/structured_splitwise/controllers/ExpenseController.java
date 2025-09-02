package structured_splitwise.controllers;

import structured_splitwise.entities.Expense;
import structured_splitwise.entities.Split;
import structured_splitwise.entities.User;
import structured_splitwise.entities.enums.ExpenseSplitType;
import structured_splitwise.services.ExpenseService;

import java.util.List;

public class ExpenseController {

    ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, User paidByUser,
                                 ExpenseSplitType splitType, List<Split> splitDetails) {
        return expenseService.createExpense(expenseId, description, expenseAmount, paidByUser, splitType, splitDetails);
    }
}
