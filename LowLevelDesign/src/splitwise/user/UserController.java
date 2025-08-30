package splitwise.user;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    List<User> userList;

    public UserController() {
        userList = new ArrayList<>();
    }

    //add-user
    public void addUser(User user) {
        userList.add(user);
    }

    //getUserById
    public User getUserById(String userID) {
        for (User user : userList) {
            if (user.getUserId().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    //getAllUser
    public List<User> getAllUsers(){
        return userList;
    }


}
