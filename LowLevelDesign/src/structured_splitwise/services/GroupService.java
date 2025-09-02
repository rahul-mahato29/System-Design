package structured_splitwise.services;

import structured_splitwise.entities.Split;
import structured_splitwise.entities.Group;
import structured_splitwise.entities.User;
import structured_splitwise.entities.enums.ExpenseSplitType;
import structured_splitwise.repositories.GroupRepository;
import structured_splitwise.entities.Expense;

import java.util.List;

public class GroupService {

    GroupRepository groupRepository;
    ExpenseService expenseService;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        this.expenseService = expenseService;
    }

    //create group
    public Group createNewGroup(String groupId, String groupName, User createdByUser) {

        //create a new group
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);

        //add the user into the group, as it is created by the USER
        group.addMember(createdByUser);

        //add the group in the list of overall groups
        groupRepository.save(group);

        return group;
    }

    public Group getGroup(String groupId){
        return groupRepository.findById(groupId);
    }

    public void addMemberToGroup(String groupId, User user) {
        Group group = groupRepository.findById(groupId);
        if (group != null) {
            group.addMember(user);
        }
    }

    public Expense createExpenseInGroup(String groupId, String expenseId, String description, double expenseAmount,
                                        List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {

        Group group = groupRepository.findById(groupId);
        if(group == null) {
            throw new RuntimeException("Group not found with Id : "+ groupId);
        }

        Expense expense = expenseService.createExpense(expenseId, description, expenseAmount, paidByUser, splitType, splitDetails);
        group.addExpense(expense);

        return expense;
    }
}
