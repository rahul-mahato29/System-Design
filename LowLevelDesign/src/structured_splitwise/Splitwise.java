package structured_splitwise;

import structured_splitwise.controllers.BalanceSheetController;
import structured_splitwise.controllers.ExpenseController;
import structured_splitwise.entities.Expense;
import structured_splitwise.entities.enums.ExpenseSplitType;
import structured_splitwise.entities.Split;
import structured_splitwise.controllers.GroupController;
import structured_splitwise.entities.User;
import structured_splitwise.controllers.UserController;
import structured_splitwise.repositories.GroupRepository;
import structured_splitwise.repositories.UserRepository;
import structured_splitwise.services.BalanceSheetService;
import structured_splitwise.services.ExpenseService;
import structured_splitwise.services.GroupService;
import structured_splitwise.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {

    //repositories
    GroupRepository groupRepository = new GroupRepository();
    UserRepository userRepository = new UserRepository();

    //services
    BalanceSheetService balanceSheetService = new BalanceSheetService();
    GroupService groupService = new GroupService(groupRepository);
    ExpenseService expenseService = new ExpenseService();
    UserService userService = new UserService(userRepository);

    //controllers
    UserController userController = new UserController(userService);
    GroupController groupController = new GroupController(groupService);
    ExpenseController expenseController = new ExpenseController(expenseService);
    BalanceSheetController balanceSheetController = new BalanceSheetController();

    //API-Call-From-Controller : Postman
    public void demo() {

        setUpUser();

        // Step 1: create & add members to group
        groupController.addMember("G1",userController.getUserById("U1"));
        groupController.addMember("G1", userController.getUserById("U2"));
        groupController.addMember("G1", userController.getUserById("U3"));
        groupController.addMember("G1", userController.getUserById("U4"));

        // Step 2: split details
        List<Split> splitDetails = new ArrayList<>();
        splitDetails.add(new Split(userController.getUserById("U1"), 200));
        splitDetails.add(new Split(userController.getUserById("U2"), 200));
        splitDetails.add(new Split(userController.getUserById("U3"), 200));
        splitDetails.add(new Split(userController.getUserById("U4"), 200));

        // Step 3: create expense in group
        groupController.createExpense("G1", "Exp2", "Dinner", 800, splitDetails,
                ExpenseSplitType.EQUAL, userController.getUserById("U1"));

        System.out.println("Successfully Expense Created");
        balanceSheetController.showBalanceSheetOfUser(userController.getUserById("U1"));
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
        User user1 = new User("User1", "U1");
        User user2 = new User("User2", "U2");
        User user3 = new User("User3", "U3");
        User user4 = new User("User4", "U4");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
        userController.addUser(user4);
    }
}
