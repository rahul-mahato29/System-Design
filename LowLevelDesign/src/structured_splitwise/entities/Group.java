package structured_splitwise.entities;

import splitwise.controllers.ExpenseController;

import java.util.ArrayList;
import java.util.List;

public class Group {

    String groupId;
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;

    ExpenseController expenseController;  //so that I can create expense through group also

    public Group(){
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    //add member to group
    public void addMember(User member){
        groupMembers.add(member);
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getGroupMembers() {
        return groupMembers;
    }
    public List<Expense> getExpenseList() {
        return expenseList;
    }
}
