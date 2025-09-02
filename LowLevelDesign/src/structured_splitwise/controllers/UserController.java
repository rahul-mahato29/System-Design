package structured_splitwise.controllers;

import structured_splitwise.entities.User;
import structured_splitwise.services.UserService;

public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public User getUserById(String userId) {
        return userService.getUserById(userId);
    }
}
