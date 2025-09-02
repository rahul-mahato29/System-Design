package structured_splitwise.services;

import structured_splitwise.controllers.BalanceSheetController;
import structured_splitwise.entities.Expense;
import structured_splitwise.entities.Split;
import structured_splitwise.entities.User;
import structured_splitwise.entities.enums.ExpenseSplitType;
import structured_splitwise.strategies.SplitFactory;
import structured_splitwise.strategies.SplitStrategy;

import java.util.List;

public class ExpenseService {

    BalanceSheetController balanceSheetController;

    public ExpenseService() {
        this.balanceSheetController = balanceSheetController;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, User paidByUser,
                                 ExpenseSplitType splitType, List<Split> splitDetails){

        SplitStrategy splitStrategy = SplitFactory.getSplitObject(splitType);
        splitStrategy.validateSplitRequest(splitDetails, expenseAmount);

        Expense expense = new Expense( expenseId, description, expenseAmount, paidByUser, splitType, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;
    }
}
