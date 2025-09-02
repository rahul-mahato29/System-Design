package splitwise.user;

import splitwise.UserExpenseBalanceSheet;

public class User {

    String userId;
    String name;
    UserExpenseBalanceSheet userExpenseBalanceSheet;  //each user will maintain there balance sheet

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }

    public String getUserId() {
        return userId;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

}
