package structured_splitwise.controllers;

import structured_splitwise.entities.Split;
import structured_splitwise.entities.User;
import structured_splitwise.services.BalanceSheetService;

import java.util.List;

public class BalanceSheetController {

    BalanceSheetService balanceSheetService;

    public BalanceSheetController() {
        this.balanceSheetService = balanceSheetService;
    }

    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount) {
        balanceSheetService.updateUserExpenseBalanceSheet(expensePaidBy, splits, totalExpenseAmount);
    }

    public void showBalanceSheetOfUser(User user) {
        balanceSheetService.showBalanceSheetOfUser(user);
    }
}
