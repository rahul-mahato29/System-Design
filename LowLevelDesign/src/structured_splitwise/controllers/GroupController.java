package structured_splitwise.controllers;

import structured_splitwise.entities.Group;
import structured_splitwise.entities.User;
import structured_splitwise.entities.Expense;
import structured_splitwise.entities.Split;
import structured_splitwise.entities.enums.ExpenseSplitType;
import structured_splitwise.services.GroupService;

import java.util.List;

public class GroupController {

    GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public void createNewGroup(String groupId, String groupName, User createdByUser) {
        groupService.createNewGroup(groupId, groupName, createdByUser);
    }

    public Group getGroup(String groupId) {
        return groupService.getGroup(groupId);
    }

    public void addMember(String groupId, User user) {
        groupService.addMemberToGroup(groupId, user);
    }

    public Expense createExpense(String groupId, String expenseId, String description, double amount,
                                 List<Split> splits, ExpenseSplitType splitType, User paidByUser) {
        return groupService.createExpenseInGroup(groupId, expenseId, description, amount, splits, splitType, paidByUser);
    }

}
