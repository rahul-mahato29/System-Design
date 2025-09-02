package splitwise.controllers;

import splitwise.BalanceSheetController;
import splitwise.expense.enums.ExpenseSplitType;
import splitwise.entities.Expense;
import splitwise.expense.split.Split;
import splitwise.expense.SplitFactory;
import splitwise.expense.split.SplitStrategy;
import splitwise.user.User;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;

    //initialization through constructor
    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
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
