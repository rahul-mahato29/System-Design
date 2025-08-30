package splitwise;

import splitwise.controllers.ExpenseController;
import splitwise.expense.enums.ExpenseSplitType;
import splitwise.expense.split.Split;
import splitwise.group.Group;
import splitwise.group.GroupController;
import splitwise.user.User;
import splitwise.user.UserController;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {

    ExpenseController expenseController;
    UserController userController;
    GroupController groupController;

    Splitwise(){
        userController = new UserController();
        expenseController = new ExpenseController();
        groupController = new GroupController();
    }


    public void demo() {

        setUpUser();

        //step-1: add member to the group
        Group group = groupController.getGroup("G1");
        group.addMember(userController.getUserById("U1"));
        group.addMember(userController.getUserById("U2"));
        group.addMember(userController.getUserById("U3"));
        group.addMember(userController.getUserById("U4"));

        //step-2: create an expense inside a group
        System.out.println("Testing Group Creation");
        List<Split> splitDetails = new ArrayList<>();
        Split split1 = new Split(userController.getUserById("U1"), 100);
        Split split2 = new Split(userController.getUserById("U2"), 100);
        Split split4 = new Split(userController.getUserById("U3"), 100);
        Split split3 = new Split(userController.getUserById("U4"), 100);

        splitDetails.add(split1);
        splitDetails.add(split2);
        splitDetails.add(split3);
        splitDetails.add(split4);

        //checking creation of Expense
//        expenseController.createExpense("Exp1", "Lunch", 400, userController.getUserById("U1"), ExpenseSplitType.EQUAL, splitDetails );

        //group expense creation
        group.createExpense("Exp2", "Dinner", 800, splitDetails, ExpenseSplitType.EQUAL, userController.getUserById("U1"));

        System.out.println("Successfully Expense Created");
    }

    public void setUpUser() {

        //onboard user to the splitwise
        addUserToSplitwise();

        //create a group by user1
        User user1 = userController.getUserById("U1");
        groupController.createNewGroup("G1", "Outing with Friends", user1);
    }

    public void addUserToSplitwise() {

        //adding User
        User user1 = new User("U1", "User1");
        User user2 = new User("U2", "User2");
        User user3 = new User("U3", "User3");
        User user4 = new User("U4", "User4");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
        userController.addUser(user4);
    }


}
