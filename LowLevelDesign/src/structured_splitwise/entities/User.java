package structured_splitwise.entities;

public class User{

    String userId;
    String name;
    UserExpenseBalanceSheet userExpenseBalanceSheet;  //each user will maintain there balance sheet

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserExpenseBalanceSheet(UserExpenseBalanceSheet userExpenseBalanceSheet) {
        this.userExpenseBalanceSheet = userExpenseBalanceSheet;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

    public String getUserId() {
        return userId;
    }
}
